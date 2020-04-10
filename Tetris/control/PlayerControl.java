/*    */ package control;
/*    */ 
/*    */ import java.awt.event.KeyAdapter;
/*    */ import java.awt.event.KeyEvent;
/*    */ 
/*    */ public class PlayerControl
/*    */   extends KeyAdapter
/*    */ {
/*    */   private GameControl gameControl;
/*    */   
/* 11 */   public PlayerControl(GameControl gameControl) { this.gameControl = gameControl; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 19 */   public void keyPressed(KeyEvent e) { this.gameControl.actionByKeyCode(e.getKeyCode()); }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar!\control\PlayerControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */