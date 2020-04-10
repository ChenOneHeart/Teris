/*    */ package ui.window;
/*    */ 
/*    */ import java.awt.event.KeyEvent;
/*    */ import java.awt.event.KeyListener;
/*    */ import javax.swing.JTextField;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TextCtrl
/*    */   extends JTextField
/*    */ {
/*    */   private int keyCode;
/*    */   private final String methodName;
/*    */   
/*    */   public TextCtrl(int x, int y, int w, int h, int keyCode, String methodName) {
/* 17 */     setBounds(x, y, w, h);
/*    */     
/* 19 */     this.methodName = methodName;
/*    */     
/* 21 */     addKeyListener(new KeyListener()
/*    */         {
/*    */           public void keyTyped(KeyEvent e) {}
/*    */ 
/*    */ 
/*    */           
/* 27 */           public void keyReleased(KeyEvent e) { TextCtrl.this.setKeyCode(e.getKeyCode()); }
/*    */ 
/*    */           
/*    */           public void keyPressed(KeyEvent e) {}
/*    */         });
/*    */   }
/*    */   
/* 34 */   public int getKeyCode() { return this.keyCode; }
/*    */ 
/*    */   
/*    */   public void setKeyCode(int keyCode) {
/* 38 */     this.keyCode = keyCode;
/* 39 */     setText(KeyEvent.getKeyText(this.keyCode));
/*    */   }
/*    */ 
/*    */   
/* 43 */   public String getMethodName() { return this.methodName; }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar\\ui\window\TextCtrl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */