/*    */ package config;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LayerConfig
/*    */   implements Serializable
/*    */ {
/*    */   private String className;
/*    */   private int x;
/*    */   private int y;
/*    */   private int w;
/*    */   private int h;
/*    */   
/*    */   public LayerConfig(String className, int x, int y, int w, int h) {
/* 20 */     this.className = className;
/* 21 */     this.x = x;
/* 22 */     this.y = y;
/* 23 */     this.w = w;
/* 24 */     this.h = h;
/*    */   }
/*    */ 
/*    */   
/* 28 */   public String getClassName() { return this.className; }
/*    */ 
/*    */ 
/*    */   
/* 32 */   public int getX() { return this.x; }
/*    */ 
/*    */ 
/*    */   
/* 36 */   public int getY() { return this.y; }
/*    */ 
/*    */ 
/*    */   
/* 40 */   public int getW() { return this.w; }
/*    */ 
/*    */ 
/*    */   
/* 44 */   public int getH() { return this.h; }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar!\config\LayerConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */