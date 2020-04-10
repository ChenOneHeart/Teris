/*     */ package ui.window;
/*     */ 
/*     */ import config.GameConfig;
/*     */ import config.LayerConfig;
/*     */ import control.GameControl;
/*     */ import control.PlayerControl;
/*     */ import dto.GameDto;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JPanel;
/*     */ import ui.Img;
/*     */ import ui.Layer;
/*     */ 
/*     */ 
/*     */ public class JPanelGame
/*     */   extends JPanel
/*     */ {
/*  24 */   private static final int BTN_SIZE_W = GameConfig.getFrameConfig().getButtonConfig().getButtonW();
/*     */   
/*  26 */   private static final int BTN_SIZE_H = GameConfig.getFrameConfig().getButtonConfig().getButtonH();
/*     */   
/*  28 */   private List<Layer> layers = null;
/*     */   
/*     */   private JButton btnStrat;
/*     */   
/*     */   private JButton btnConfig;
/*     */   
/*  34 */   private GameControl gameControl = null;
/*     */ 
/*     */   
/*     */   public JPanelGame(GameControl gameControl, GameDto dto) {
/*  38 */     this.gameControl = gameControl;
/*     */     
/*  40 */     setLayout(null);
/*     */     
/*  42 */     initComponent();
/*     */     
/*  44 */     initLayer(dto);
/*     */     
/*  46 */     addKeyListener((KeyListener)new PlayerControl(gameControl));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   public void setGameControl(PlayerControl control) { addKeyListener((KeyListener)control); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initComponent() {
/*  61 */     this.btnStrat = new JButton(Img.BTN_START);
/*     */     
/*  63 */     this.btnStrat.setBounds(
/*  64 */         GameConfig.getFrameConfig().getButtonConfig().getStartX(), 
/*  65 */         GameConfig.getFrameConfig().getButtonConfig().getStartY(), 
/*  66 */         BTN_SIZE_W, BTN_SIZE_H);
/*     */     
/*  68 */     this.btnStrat.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*  70 */             JPanelGame.this.gameControl.start();
/*     */             
/*  72 */             JPanelGame.this.requestFocus();
/*     */           }
/*     */         });
/*     */     
/*  76 */     add(this.btnStrat);
/*     */     
/*  78 */     this.btnConfig = new JButton(Img.BTN_CONFIG);
/*     */     
/*  80 */     this.btnConfig.setBounds(
/*  81 */         GameConfig.getFrameConfig().getButtonConfig().getUserConfigX(), 
/*  82 */         GameConfig.getFrameConfig().getButtonConfig().getUserConfigY(), 
/*  83 */         BTN_SIZE_W, BTN_SIZE_H);
/*     */     
/*  85 */     this.btnConfig.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*  87 */             JPanelGame.this.gameControl.showUserConfig();
/*     */           }
/*     */         });
/*     */     
/*  91 */     add(this.btnConfig);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initLayer(GameDto dto) {
/*     */     try {
/* 100 */       List<LayerConfig> layersCfg = GameConfig.getFrameConfig().getLayersConfig();
/*     */       
/* 102 */       this.layers = new ArrayList<>(layersCfg.size());
/*     */       
/* 104 */       for (LayerConfig layerCfg : layersCfg) {
/*     */         
/* 106 */         Class<?> cls = Class.forName(layerCfg.getClassName());
/*     */         
/* 108 */         Constructor<?> ctr = cls.getConstructor(new Class[] { int.class, int.class, int.class, int.class });
/*     */         
/* 110 */         Layer layer = (Layer)ctr.newInstance(new Object[] {
/* 111 */               Integer.valueOf(layerCfg.getX()), Integer.valueOf(layerCfg.getY()), Integer.valueOf(layerCfg.getW()), Integer.valueOf(layerCfg.getH())
/*     */             });
/*     */         
/* 114 */         layer.setDto(dto);
/*     */         
/* 116 */         this.layers.add(layer);
/*     */       } 
/* 118 */     } catch (Exception e) {
/* 119 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void paintComponent(Graphics g) {
/* 126 */     super.paintComponent(g);
/*     */     
/* 128 */     for (int i = 0; i < this.layers.size(); ((Layer)this.layers.get(i++)).paint(g));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void buttonSwitch(boolean onOff) {
/* 135 */     this.btnConfig.setEnabled(onOff);
/* 136 */     this.btnStrat.setEnabled(onOff);
/* 137 */     repaint();
/*     */   }
/*     */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar\\ui\window\JPanelGame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */