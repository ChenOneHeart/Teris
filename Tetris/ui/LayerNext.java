/*    */ package ui;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class LayerNext
/*    */   extends Layer
/*    */ {
/*  8 */   public LayerNext(int x, int y, int w, int h) { super(x, y, w, h); }
/*    */ 
/*    */   
/*    */   public void paint(Graphics g) {
/* 12 */     createWindow(g);
/*    */     
/* 14 */     if (this.dto.isStart())
/* 15 */       drawImageActCenter(Img.NEXT_ACT[this.dto.getNext()], g); 
/*    */   }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar\\ui\LayerNext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */