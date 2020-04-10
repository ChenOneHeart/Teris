/*     */ package control;
/*     */ 
/*     */ import config.DataInterfaceConfig;
/*     */ import config.GameConfig;
/*     */ import dao.Data;
/*     */ import dto.GameDto;
/*     */ import dto.Player;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import service.GameService;
/*     */ import service.GameTetris;
/*     */ import ui.window.JFrameConfig;
/*     */ import ui.window.JFrameSavePoint;
/*     */ import ui.window.JPanelGame;
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
/*     */ public class GameControl
/*     */ {
/*     */   private Data dataA;
/*     */   private Data dataB;
/*     */   private GameService gameService;
/*     */   private JPanelGame panelGame;
/*     */   private JFrameConfig frameConfig;
/*     */   private JFrameSavePoint frameSavePoint;
/*     */   private Map<Integer, Method> actionList;
/*  71 */   private GameDto dto = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  76 */   private Thread gameThread = null;
/*     */ 
/*     */   
/*     */   public GameControl() {
/*  80 */     this.dto = new GameDto();
/*     */     
/*  82 */     this.gameService = (GameService)new GameTetris(this.dto);
/*     */     
/*  84 */     this.dataA = createDataObject(GameConfig.getDataConfig().getDataA());
/*     */     
/*  86 */     this.dto.setDbRecode(this.dataA.loadData());
/*     */     
/*  88 */     this.dataB = createDataObject(GameConfig.getDataConfig().getDataB());
/*     */     
/*  90 */     this.dto.setDiskRecode(this.dataB.loadData());
/*     */     
/*  92 */     this.panelGame = new JPanelGame(this, this.dto);
/*     */     
/*  94 */     setControlConfig();
/*     */     
/*  96 */     this.frameConfig = new JFrameConfig(this);
/*     */     
/*  98 */     this.frameSavePoint = new JFrameSavePoint(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setControlConfig() {
/* 108 */     this.actionList = new HashMap<>();
/*     */     
/*     */     try {
/* 111 */       ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/control.dat"));
/*     */       
/* 113 */       HashMap<Integer, String> cfgSet = (HashMap<Integer, String>)ois.readObject();
/* 114 */       Set<Map.Entry<Integer, String>> entryset = cfgSet.entrySet();
/* 115 */       for (Map.Entry<Integer, String> e : entryset) {
/* 116 */         this.actionList.put(e.getKey(), this.gameService.getClass().getMethod(e.getValue(), new Class[0]));
/*     */       }
/* 118 */     } catch (Exception e) {
/* 119 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Data createDataObject(DataInterfaceConfig cfg) {
/*     */     try {
/* 129 */       Class<?> cls = Class.forName(cfg.getClassName());
/*     */       
/* 131 */       Constructor<?> ctr = cls.getConstructor(new Class[] { HashMap.class });
/*     */       
/* 133 */       return (Data)ctr.newInstance(new Object[] { cfg.getParam() });
/* 134 */     } catch (Exception e) {
/* 135 */       e.printStackTrace();
/* 136 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void actionByKeyCode(int keyCode) {
/*     */     try {
/* 146 */       if (!this.actionList.containsKey(Integer.valueOf(keyCode)) || !this.dto.isStart()) {
/*     */         return;
/*     */       }
/* 149 */       ((Method)this.actionList.get(Integer.valueOf(keyCode))).invoke(this.gameService, new Object[0]);
/* 150 */     } catch (Exception e) {
/* 151 */       e.printStackTrace();
/*     */     } 
/* 153 */     this.panelGame.repaint();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 160 */   public void showUserConfig() { this.frameConfig.setVisible(true); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOver() {
/* 167 */     this.panelGame.repaint();
/* 168 */     setControlConfig();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/* 176 */     this.panelGame.buttonSwitch(false);
/*     */     
/* 178 */     this.frameConfig.setVisible(false);
/* 179 */     this.frameSavePoint.setVisible(false);
/*     */     
/* 181 */     this.gameService.startGame();
/*     */     
/* 183 */     this.gameThread = new MainThread(null);
/*     */     
/* 185 */     this.gameThread.start();
/*     */     
/* 187 */     this.panelGame.repaint();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void savePoint(String name) {
/* 194 */     Player pla = new Player(name, this.dto.getNowPoint());
/*     */     
/* 196 */     this.dataA.saveData(pla);
/*     */     
/* 198 */     this.dataB.saveData(pla);
/*     */     
/* 200 */     this.dto.setDbRecode(this.dataA.loadData());
/*     */     
/* 202 */     this.dto.setDiskRecode(this.dataB.loadData());
/*     */     
/* 204 */     this.panelGame.repaint();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void afterLose() {
/* 211 */     if (!this.dto.isCheat())
/*     */     {
/* 213 */       this.frameSavePoint.showWindow(this.dto.getNowPoint());
/*     */     }
/*     */     
/* 216 */     this.panelGame.buttonSwitch(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 223 */   public void repaint() { this.panelGame.repaint(); }
/*     */   
/*     */   private class MainThread
/*     */     extends Thread {
/*     */     private MainThread() {}
/*     */     
/*     */     public void run() {
/* 230 */       GameControl.this.panelGame.repaint();
/*     */       
/* 232 */       while (GameControl.this.dto.isStart()) {
/*     */         
/*     */         try {
/* 235 */           Thread.sleep(GameControl.this.dto.getSleepTime());
/*     */           
/* 237 */           if (GameControl.this.dto.isPause()) {
/*     */             continue;
/*     */           }
/*     */           
/* 241 */           GameControl.this.gameService.mainAction();
/*     */           
/* 243 */           GameControl.this.panelGame.repaint();
/* 244 */         } catch (Exception e) {
/* 245 */           e.printStackTrace();
/*     */         } 
/*     */       } 
/* 248 */       GameControl.this.afterLose();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar!\control\GameControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */