/*    */ package ui;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class LayerDataBase
/*    */   extends LayerData
/*    */ {
/*  8 */   public LayerDataBase(int x, int y, int w, int h) { super(x, y, w, h); }
/*    */ 
/*    */   
/*    */   public void paint(Graphics g) {
/* 12 */     createWindow(g);
/* 13 */     showData(Img.DB, this.dto.getDbRecode(), g);
/*    */   }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar\\ui\LayerDataBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */