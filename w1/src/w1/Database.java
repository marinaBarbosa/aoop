/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w1;
/**
 *
 * @author marina
 * Source : http://www.geeksforgeeks.org/program-round-robin-scheduling-set-1/
 */

interface IConnection { 
    char get(int index); 
    void set(int index, char c); 
    int length(); 
}

class Database { 
    private char[] tab = new char[100]; 
    //Database should be the Singleton
    private Database(){};
    
    public static IConnection getConnection() { 
        return Connection.getInstance();
    } 
    
    private static class Connection implements IConnection { 
        private Database db;        
        private static int index = 0;
        private static Connection[] connection;

    private Connection (Database db) {
        this.db = db;
    }
    
    public static IConnection getInstance(){    
        if (connection == null) {
            Database c = new Database();
            //Multitons: there exists only three of them returned by the getInstance method 
            connection = new Connection[]{ new Connection(c),new Connection(c),new Connection(c) };
        }
        //round-robin fasion
        index = (index+1) % connection.length;
        return connection[index]; 
    } 
    public char get(int index) { 
      return db.tab[index]; 
    } 
    public void set(int index, char c) {
      db.tab[index] = c; 
    }
    public int length() { 
      return db.tab.length; 
    } 
  } 
} 
