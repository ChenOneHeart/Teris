/*    */ package dto;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class Player
/*    */   implements Comparable<Player>, Serializable {
/*    */   private String name;
/*    */   private int point;
/*    */   
/*    */   public Player(String name, int point) {
/* 11 */     this.name = name;
/* 12 */     this.point = point;
/*    */   }
/*    */   
/* 15 */   public String getName() { return this.name; }
/*    */ 
/*    */   
/* 18 */   public void setName(String name) { this.name = name; }
/*    */ 
/*    */   
/* 21 */   public int getPoint() { return this.point; }
/*    */ 
/*    */   
/* 24 */   public void setPoint(int point) { this.point = point; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 30 */   public int compareTo(Player pla) { return pla.point - this.point; }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar!\dto\Player.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */