/*     */ package ui;
/*     */ 
/*     */ import config.FrameConfig;
/*     */ import config.GameConfig;
/*     */ import dto.GameDto;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Layer
/*     */ {
/*     */   protected static final int PADDING;
/*     */   protected static final int BORDER;
/*     */   private static int WINDOW_W;
/*     */   private static int WINDOW_H;
/*     */   protected static final int IMG_NUMBER_W;
/*     */   private static final int IMG_NUMBER_H;
/*     */   protected static final int IMG_RECT_H;
/*     */   private static final int IMG_RECT_W;
/*     */   private final int rectW;
/*     */   private static final Font DFF_FONT;
/*     */   protected int x;
/*     */   protected int y;
/*     */   protected int w;
/*     */   protected int h;
/*     */   
/*     */   static  {
/*  31 */     FrameConfig fCfg = GameConfig.getFrameConfig();
/*  32 */     PADDING = fCfg.getPadding();
/*  33 */     BORDER = fCfg.getBoder();
/*     */ 
/*     */     
/*  36 */     WINDOW_W = Img.WINDOW.getWidth(null);
/*     */     
/*  38 */     WINDOW_H = Img.WINDOW.getHeight(null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  44 */     IMG_NUMBER_W = Img.NUMBER.getWidth(null) / 10;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  49 */     IMG_NUMBER_H = Img.NUMBER.getHeight(null);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  54 */     IMG_RECT_H = Img.RECT.getHeight(null);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  59 */     IMG_RECT_W = Img.RECT.getWidth(null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  69 */     DFF_FONT = new Font("黑体", 1, 24);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  94 */   protected GameDto dto = null;
/*     */   
/*     */   public Layer(int x, int y, int w, int h) {
/*  97 */     this.x = x;
/*  98 */     this.y = y;
/*  99 */     this.w = w;
/* 100 */     this.h = h;
/* 101 */     this.rectW = this.w - (PADDING << 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void createWindow(Graphics g) {
/* 113 */     g.drawImage(Img.WINDOW, this.x, this.y, this.x + BORDER, this.y + BORDER, 0, 0, BORDER, BORDER, null);
/*     */     
/* 115 */     g.drawImage(Img.WINDOW, this.x + BORDER, this.y, this.x + this.w - BORDER, this.y + BORDER, BORDER, 0, WINDOW_W - BORDER, BORDER, null);
/*     */     
/* 117 */     g.drawImage(Img.WINDOW, this.x + this.w - BORDER, this.y, this.x + this.w, this.y + BORDER, WINDOW_W - BORDER, 0, WINDOW_W, BORDER, null);
/*     */     
/* 119 */     g.drawImage(Img.WINDOW, this.x, this.y + BORDER, this.x + BORDER, this.y + this.h - BORDER, 0, BORDER, BORDER, WINDOW_H - BORDER, null);
/*     */     
/* 121 */     g.drawImage(Img.WINDOW, this.x + BORDER, this.y + BORDER, this.x + this.w - BORDER, this.y + this.h - BORDER, BORDER, BORDER, WINDOW_W - BORDER, WINDOW_H - BORDER, null);
/*     */     
/* 123 */     g.drawImage(Img.WINDOW, this.x + this.w - BORDER, this.y + BORDER, this.x + this.w, this.y + this.h - BORDER, WINDOW_W - BORDER, BORDER, WINDOW_W, WINDOW_H - BORDER, null);
/*     */     
/* 125 */     g.drawImage(Img.WINDOW, this.x, this.y + this.h - BORDER, this.x + BORDER, this.y + this.h, 0, WINDOW_H - BORDER, BORDER, WINDOW_H, null);
/*     */     
/* 127 */     g.drawImage(Img.WINDOW, this.x + BORDER, this.y + this.h - BORDER, this.x + this.w - BORDER, this.y + this.h, BORDER, WINDOW_H - BORDER, WINDOW_W - BORDER, WINDOW_H, null);
/*     */     
/* 129 */     g.drawImage(Img.WINDOW, this.x + this.w - BORDER, this.y + this.h - BORDER, this.x + this.w, this.y + this.h, WINDOW_W - BORDER, WINDOW_H - BORDER, WINDOW_W, WINDOW_H, null);
/*     */   }
/*     */ 
/*     */   
/* 133 */   public void setDto(GameDto dto) { this.dto = dto; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void drawNumberLeftPad(int x, int y, int num, int maxBit, Graphics g) {
/* 147 */     String strNum = Integer.toString(num);
/*     */     
/* 149 */     for (int i = 0; i < maxBit; i++) {
/* 150 */       if (maxBit - i <= strNum.length()) {
/*     */         
/* 152 */         int idx = i - maxBit + strNum.length();
/*     */         
/* 154 */         int bit = strNum.charAt(idx) - 48;
/*     */         
/* 156 */         g.drawImage(Img.NUMBER, 
/* 157 */             this.x + x + IMG_NUMBER_W * i, this.y + y, 
/* 158 */             this.x + x + IMG_NUMBER_W * (i + 1), this.y + y + IMG_NUMBER_H, 
/* 159 */             bit * IMG_NUMBER_W, 0, (
/* 160 */             bit + 1) * IMG_NUMBER_W, IMG_NUMBER_H, null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void drawRect(int y, String title, String number, double percent, Graphics g) {
/* 170 */     int rect_x = this.x + PADDING;
/* 171 */     int rect_y = this.y + y;
/*     */     
/* 173 */     g.setColor(Color.BLACK);
/* 174 */     g.fillRect(rect_x, rect_y, this.rectW, IMG_RECT_H + 4);
/* 175 */     g.setColor(Color.WHITE);
/* 176 */     g.fillRect(rect_x + 1, rect_y + 1, this.rectW - 2, IMG_RECT_H + 2);
/* 177 */     g.setColor(Color.BLACK);
/* 178 */     g.fillRect(rect_x + 2, rect_y + 2, this.rectW - 4, IMG_RECT_H);
/*     */ 
/*     */     
/* 181 */     int w = (int)(percent * (this.rectW - 4));
/*     */     
/* 183 */     int subIdx = (int)(percent * IMG_RECT_W) - 1;
/*     */     
/* 185 */     g.drawImage(Img.RECT, 
/* 186 */         rect_x + 2, rect_y + 2, 
/* 187 */         rect_x + 2 + w, rect_y + 2 + IMG_RECT_H, 
/* 188 */         subIdx, 0, subIdx + 1, IMG_RECT_H, 
/* 189 */         null);
/* 190 */     g.setColor(Color.WHITE);
/* 191 */     g.setFont(DFF_FONT);
/* 192 */     g.drawString(title, rect_x, rect_y + 24);
/* 193 */     if (number != null) {
/* 194 */       g.drawString(number, rect_x + 232, rect_y + 22);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void drawImageActCenter(Image img, Graphics g) {
/* 202 */     int imgW = img.getWidth(null);
/* 203 */     int imgH = img.getHeight(null);
/* 204 */     g.drawImage(img, this.x + (this.w - imgW >> 1), this.y + (this.h - imgH >> 1), null);
/*     */   }
/*     */   
/*     */   public abstract void paint(Graphics paramGraphics);
/*     */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar\\ui\Layer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */