/*    */ package ui;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ 
/*    */ public class LayerAbout
/*    */   extends Layer
/*    */ {
/*  9 */   public LayerAbout(int x, int y, int w, int h) { super(x, y, w, h); }
/*    */ 
/*    */ 
/*    */   
/*    */   public void paint(Graphics g) {
/* 14 */     createWindow(g);
/* 15 */     drawImageActCenter(Img.SIGN, g);
/*    */   }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar\\ui\LayerAbout.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */