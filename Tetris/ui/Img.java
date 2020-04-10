/*     */ package ui;
/*     */ 
/*     */ import config.GameConfig;
/*     */ import java.awt.Image;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.swing.ImageIcon;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Img
/*     */ {
/*     */   public static final String GRAPHICS_PATH = "graphics/";
/*     */   private static final String DEFAULT_PATH = "动漫/";
/*     */   
/*     */   public static void setSkin(String path) {
/*  23 */     String skinPath = "graphics/" + path;
/*     */     
/*  25 */     SIGN = (new ImageIcon(String.valueOf(skinPath) + "string/sign.png")).getImage();
/*     */     
/*  27 */     WINDOW = (new ImageIcon(String.valueOf(skinPath) + "window/window.png")).getImage();
/*     */     
/*  29 */     NUMBER = (new ImageIcon(String.valueOf(skinPath) + "string/num.png")).getImage();
/*     */     
/*  31 */     RECT = (new ImageIcon(String.valueOf(skinPath) + "window/rect.png")).getImage();
/*     */     
/*  33 */     DB = (new ImageIcon(String.valueOf(skinPath) + "string/db.png")).getImage();
/*     */     
/*  35 */     DISK = (new ImageIcon(String.valueOf(skinPath) + "string/disk.png")).getImage();
/*     */     
/*  37 */     ACT = (new ImageIcon(String.valueOf(skinPath) + "game/rect.png")).getImage();
/*     */     
/*  39 */     LEVEL = (new ImageIcon(String.valueOf(skinPath) + "string/level.png")).getImage();
/*     */     
/*  41 */     POINT = (new ImageIcon(String.valueOf(skinPath) + "string/point.png")).getImage();
/*     */     
/*  43 */     RMLINE = (new ImageIcon(String.valueOf(skinPath) + "string/rmline.png")).getImage();
/*     */     
/*  45 */     SHODOW = (new ImageIcon(String.valueOf(skinPath) + "game/shodow.png")).getImage();
/*     */     
/*  47 */     BTN_START = new ImageIcon(String.valueOf(skinPath) + "string/start.png");
/*     */     
/*  49 */     BTN_CONFIG = new ImageIcon(String.valueOf(skinPath) + "string/config.png");
/*     */     
/*  51 */     PAUSE = (new ImageIcon(String.valueOf(skinPath) + "string/pause.png")).getImage();
/*     */     
/*  53 */     NEXT_ACT = new Image[GameConfig.getSystemConfig().getTypeConfig().size()];
/*  54 */     for (int i = 0; i < NEXT_ACT.length; i++) {
/*  55 */       NEXT_ACT[i] = (new ImageIcon(String.valueOf(skinPath) + "/game/" + i + ".png")).getImage();
/*     */     }
/*     */     
/*  58 */     File dir = new File(String.valueOf(skinPath) + "/background");
/*  59 */     File[] files = dir.listFiles();
/*  60 */     BG_LIST = new ArrayList<>(); byte b; int j; File[] arrayOfFile;
/*  61 */     for (j = (arrayOfFile = files).length, b = 0; b < j; ) { File file = arrayOfFile[b];
/*  62 */       if (!file.isDirectory()) {
/*  63 */         BG_LIST.add((new ImageIcon(file.getPath())).getImage());
/*     */       }
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  71 */   public static Image SIGN = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  76 */   public static Image WINDOW = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  81 */   public static Image NUMBER = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  86 */   public static Image RECT = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  91 */   public static Image DB = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  96 */   public static Image DISK = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 101 */   public static Image ACT = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 106 */   public static Image LEVEL = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 111 */   public static Image POINT = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 116 */   public static Image RMLINE = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 121 */   public static Image SHODOW = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 126 */   public static ImageIcon BTN_START = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 131 */   public static ImageIcon BTN_CONFIG = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 136 */   public static Image PAUSE = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 141 */   public static Image[] NEXT_ACT = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 146 */   public static List<Image> BG_LIST = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static  {
/* 152 */     setSkin("动漫/");
/*     */   }
/*     */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar\\ui\Img.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */