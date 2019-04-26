/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author willi
 */
public class Player {
    
    private int gold;
    
    public Player(){
    this.gold = 100;
    }
   
    
    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
    
    public void setNewgold(int g) {
        this.gold = this.gold - g;
    }
    
    
}
