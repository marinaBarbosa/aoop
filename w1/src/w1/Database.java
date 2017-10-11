/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w1;
/**
 *
 * @author marina
 */

interface IConnection { 
    char get(int index); 
    void set(int index, char c); 
    int length(); 
}

class Database { 
    private char[] tab = new char[100]; 
    /* ... */ 

  
    private Database(){};
    
    
  public static IConnection getConnection() { 
     return Connection.getInstance();
  } 
  private static class Connection implements IConnection { 
    private Database db; 
    /* ... */ 
       
    private static int index = 0;
    private static Connection[] connection;

    private Connection (Database db) {
        this.db = db;
    }
    public static IConnection getInstance(){
      /* ... */ 
        if (connection == null) {
            Database c = new Database();
            connection = new Connection[]{new Connection(c),new Connection(c),new Connection(c)};
        }
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
