/*     */ package ui;
/*     */ 
/*     */ import config.GameConfig;
/*     */ import entity.GameAct;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Point;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LayerGame
/*     */   extends Layer
/*     */ {
/*  14 */   private static final int SIZE_ROL = GameConfig.getFrameConfig().getSizeRol();
/*     */   
/*     */   private static final int LEFT_SIDE = 0;
/*     */   
/*  18 */   private static final int RIGHT_SIDE = GameConfig.getSystemConfig().getMaxX();
/*     */   
/*  20 */   private static final int LOSE_IDX = GameConfig.getFrameConfig().getLoseIdx();
/*     */ 
/*     */   
/*  23 */   public LayerGame(int x, int y, int w, int h) { super(x, y, w, h); }
/*     */ 
/*     */   
/*     */   public void paint(Graphics g) {
/*  27 */     createWindow(g);
/*     */     
/*  29 */     GameAct act = this.dto.getGameAct();
/*  30 */     if (act != null) {
/*  31 */       Point[] points = this.dto.getGameAct().getActPoints();
/*     */       
/*  33 */       drawShadow(points, g);
/*     */       
/*  35 */       drawMainAct(points, g);
/*     */     } 
/*     */     
/*  38 */     drawMap(g);
/*     */     
/*  40 */     if (this.dto.isPause()) {
/*  41 */       drawImageActCenter(Img.PAUSE, g);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void drawMainAct(Point[] points, Graphics g) {
/*  52 */     int typeCode = this.dto.getGameAct().getTypeCode();
/*     */     
/*  54 */     for (int i = 0; i < points.length; i++) {
/*  55 */       drawActByPoint((points[i]).x, (points[i]).y, typeCode + 1, g);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void drawMap(Graphics g) {
/*  65 */     boolean[][] map = this.dto.getGameMap();
/*     */     
/*  67 */     int lv = this.dto.getNowlevel();
/*  68 */     int imgIdx = (lv == 0) ? 0 : ((lv - 1) % 7 + 1);
/*  69 */     for (int x = 0; x < map.length; x++) {
/*  70 */       for (int y = 0; y < (map[x]).length; y++) {
/*  71 */         if (map[x][y]) {
/*  72 */           drawActByPoint(x, y, imgIdx, g);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void drawShadow(Point[] points, Graphics g) {
/*  83 */     if (!this.dto.isShowShadow()) {
/*     */       return;
/*     */     }
/*  86 */     int leftX = RIGHT_SIDE;
/*  87 */     int rightX = 0; byte b; int i; Point[] arrayOfPoint;
/*  88 */     for (i = (arrayOfPoint = points).length, b = 0; b < i; ) { Point p = arrayOfPoint[b];
/*  89 */       leftX = (p.x < leftX) ? p.x : leftX;
/*  90 */       rightX = (p.x > rightX) ? p.x : rightX; b++; }
/*     */     
/*  92 */     g.drawImage(Img.SHODOW, 
/*  93 */         this.x + BORDER + (leftX << SIZE_ROL), 
/*  94 */         this.y + BORDER, 
/*  95 */         rightX - leftX + 1 << SIZE_ROL, 
/*  96 */         this.h - (BORDER << 1), 
/*  97 */         null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void drawActByPoint(int x, int y, int imgIdx, Graphics g) {
/* 104 */     imgIdx = this.dto.isStart() ? imgIdx : LOSE_IDX;
/* 105 */     g.drawImage(Img.ACT, 
/* 106 */         this.x + (x << SIZE_ROL) + BORDER, 
/* 107 */         this.y + (y << SIZE_ROL) + BORDER, 
/* 108 */         this.x + (x + 1 << SIZE_ROL) + BORDER, 
/* 109 */         this.y + (y + 1 << SIZE_ROL) + BORDER, 
/* 110 */         imgIdx << SIZE_ROL, 0, imgIdx + 1 << SIZE_ROL, 1 << SIZE_ROL, null);
/*     */   }
/*     */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar\\ui\LayerGame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */