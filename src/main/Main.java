package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import etc.Constants;
import etc.DPSPanel;
import damage.Damage;
import damage.SurfaceDamage;
import etc.UIBuilder;
import mods.Mod;
import mods.ModManagerPanel;
import ttk.TTKManagerPanel;
import ttk.TTKTarget;
import weapons.ArcGunPanel;
import weapons.PistolPanel;
import weapons.RiflePanel;
import weapons.ShotgunPanel;
import weapons.MeleePanel;
import weapons.WeaponManagerPanel;
import weapons.WeaponPanel;
import options.ColorOptionsPanel;
import Maximizer.Maximizer;
import Stances.Stance.Combo;
import Stances.Stance.Hit;
import Stances.StanceManagerPanel;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main {

	/**
	 * ____________________________________________________________ GLOBAL VARIABLES
	 * ____________________________________________________________
	 */

	/** JFrames **/
	protected static JFrame mainFrame = new JFrame();
	protected static JFrame modManagerFrame = new JFrame();
	protected static JFrame targetManagerFrame = new JFrame();
	public static JFrame weaponManagerFrame = new JFrame();
	protected static JFrame colorOptionsFrame = new JFrame();
	public static JFrame stanceManagerFrame = new JFrame();

	/** JButtons **/
	protected static JButton calculateButton = new JButton("Calculate");
	protected static JButton clearOutputButton = new JButton("Clear Output");
	protected static JButton maximizeButton = new JButton("Maximize");
	protected static JButton stopButton = new JButton("Cancel Calculation");
	protected static JButton quickTargetButton = new JButton("Add");
	protected static JButton removeTargetButton = new JButton("Remove");

	protected static JLabel TTKIterationsLabel = new JLabel("TTK Iterations:");
	protected static JTextField TTKIterationsField = new JTextField(4);
	public static JTextField targetLevelField = new JTextField(4);
	protected static JLabel targetLevelLabel = new JLabel("Level");
	protected static JLabel loadingLabel = new JLabel("CALCULATING");

	/** JTextAreas **/
	public static JTextArea output = new JTextArea();

	protected static DefaultListModel enemyListModel = new DefaultListModel();
	protected static JList enemyList = new JList(enemyListModel);

	/** JTabbedPanes **/
	protected static JTabbedPane weaponPane = new JTabbedPane();

	/** JScrollPanes **/
	protected static JScrollPane outputScroll = new JScrollPane(output);

	/** JPanels **/
	protected static JPanel mainPanel = new JPanel();
	protected static JPanel secondaryPanel = new JPanel();
	protected static JPanel deepsPanel = new JPanel();
	protected static JPanel topPanel = new JPanel();
	protected static JPanel bottomPanel = new JPanel();
	protected static JPanel loadingScreen = (JPanel) mainFrame.getGlassPane();
	protected static RiflePanel riflePanel;
	protected static ShotgunPanel shotgunPanel;
	protected static PistolPanel pistolPanel;
	protected static ArcGunPanel arcGunPanel;
	public static MeleePanel meleePanel;
	protected static ModManagerPanel theModManager = null;
	protected static TTKManagerPanel theTTKManager = null;
	protected static WeaponManagerPanel theWeaponManager = null;
	protected static ColorOptionsPanel theColorPanel = null;
	protected static StanceManagerPanel theStanceManager = null;
	protected static DPSPanel DPSPanel = new DPSPanel();

	/** JMenuBar **/
	protected static JMenuBar mainMenuBar = new JMenuBar();

	/** JMenuItems **/
	protected static JMenu fileMenu = new JMenu("File");
	protected static JMenuItem modMenu = new JMenuItem("Mod Manager");
	protected static JMenuItem TTKMenu = new JMenuItem("Target Manager");
	protected static JMenuItem weaponMenu = new JMenuItem("Weapon Manager");
	protected static JMenuItem stanceMenu = new JMenuItem("Stance Manager");
	protected static JMenuItem saveItem = new JMenuItem("Save");
	protected static JMenuItem loadItem = new JMenuItem("Load");
	protected static JMenuItem colorOptionsItem = new JMenuItem("Color Options");

	/** JFileChoosers **/
	protected static JFileChooser chooser = new JFileChooser();

	/** Misc UI Components **/
	protected static MainActionListener action = new MainActionListener();
	protected static MainChangeListener change = new MainChangeListener();
	protected static MainWindowListener window = new MainWindowListener();
	protected static Boolean modManagerInit = false;
	protected static Boolean targetManagerInit = false;
	protected static Boolean weaponManagerInit = false;
	protected static Boolean colorOptionsInit = false;
	protected static Boolean stanceManagerInit = false;
	protected static JLabel targetGroupLabel = new JLabel("Group:");
	public static JComboBox targetGroupBox = new JComboBox();
	protected static JLabel corrosiveProjectionLabel = new JLabel("CPs:");
	protected static JLabel shieldDisruptionLabel = new JLabel("SDs:");
	protected static JComboBox corrosiveProjectionBox = new JComboBox();
	protected static JComboBox shieldDisruptionBox = new JComboBox();
	protected static JCheckBox headShots = new JCheckBox("Headshots");
	public static JCheckBox smartMax = new JCheckBox("SmartMax");

	/** Data **/

	/** Selected WeaponPanel **/
	public static WeaponPanel selectedWeapon = null;

	/** The Maximizer **/
	public static Maximizer theMaximizer = new Maximizer();
	public static JProgressBar progressBar;

	/** Mod Vectors **/
	protected static Vector<Mod> activeMods = new Vector<Mod>();
	protected static Vector<Integer> modRanks = new Vector<Integer>();
	public static Vector<TTKTarget> groupTargets;

	/** Base Values **/
	protected static boolean useComplexTTK = true;
	public static int complexTTKIterations = 10000;
	// public static int complexTTKCompletions = 0;
	public static String longestTTKName = "";
	public static int maxTTKTime = 6000000;

	public static String weaponName = "";
	public static String weaponMode = "";
	protected static String damageType = "";
	protected static String damage2Type = "";
	protected static String explosiveDamage1Type = "";
	protected static String explosiveDamage2Type = "";
	protected static double chargeTime = 0.0;
	public static double fireRate = 0.0;
	protected static double reloadTime = 0.0;
	public static double critChance = 0.0;
	protected static double critMult = 0.0;
	public static double projectileCount = 0.0;
	protected static double firstShotDamageMult = 1.0;
	protected static double lastShotDamageMult = 1.0;
	public static double statusChance = 0.0;
	protected static double statusDuration = 1.0;
	protected static double damageMult = 1.0;
	protected static double deadAimMult = 1.0;
	protected static double flatDamageBonus = 0.0;
	protected static int mag = 0;
	public static int combo = 0;
	public static double startingCombo = 0;
	public static int burstCount = 0;
	public static double drain = 1;
	public static int shatteringImpact = 0;
	public static String forcedProc = "";

	/** Calculated Values **/
	public static int finalMag = 0;
	protected static int finalAmmo = 0;
	protected static double finalIterationTime = 0.0;
	protected static double finalIterationsPerMinute = 0.0;
	protected static double averageCritMult = 0.0;
	public static double finalCritChance = 0.0;
	public static double finalComboCrit = 0.0;
	public static double finalCritMult = 0.0;
	public static double finalFireRate = 0.0;
	public static double finalReloadTime = 0.0;
	public static double finalProjectileCount = 0.0;
	public static double finalFirstShotDamageMult = 1.0;
	public static double finalLastShotDamageMult = 1.0;
	public static double finalStatusChance = 0.0;
	public static double finalStatusDuration = 1.0;
	public static double finalDamageMult = 1.0;
	public static double finalDeadAimMult = 1.0;
	protected static double finalFlatDamageBonus = 0.0;
	public static double finalCorpusMult = 1.0;
	public static double finalGrineerMult = 1.0;
	public static double finalInfestedMult = 1.0;
	public static double finalCorruptedMult = 1.0;
	public static double averageProjectileCount = 1;
	public static double averageStatusChance = 0;

	/** Damage/DPS Values **/
	// Misc Values
	protected static double procsPerSecond = 0.0;
	protected static double burstProcsPerSecond = 0.0;
	protected static double slashStacks = 0;
	protected static double fireStacks = 0;
	protected static double toxinStacks = 0;
	protected static double gasStacks = 0;
	protected static double electricStacks = 0;
	protected static double burstSlashStacks = 0;
	protected static double burstFireStacks = 0;
	protected static double burstToxinStacks = 0;
	protected static double burstGasStacks = 0;
	protected static double burstElectricStacks = 0;
	protected static double explosiveSlashStacks = 0;
	protected static double explosiveBurstSlashStacks = 0;
	protected static double explosiveToxinStacks = 0;
	protected static double explosiveBurstToxinStacks = 0;
	protected static double explosiveGasStacks = 0;
	protected static double explosiveBurstGasStacks = 0;
	protected static double explosiveElectricStacks = 0;
	protected static double explosiveBurstElectricStacks = 0;
	protected static double explosiveFireStacks = 0;
	protected static double explosiveBurstFireStacks = 0;

	public static Damage raw = new Damage();
	public static Damage impact = new Damage();
	public static Damage puncture = new Damage();
	public static Damage slash = new Damage();
	public static Damage fire = new Damage();
	public static Damage ice = new Damage();
	public static Damage electric = new Damage();
	public static Damage toxin = new Damage();
	public static Damage blast = new Damage();
	public static Damage magnetic = new Damage();
	public static Damage gas = new Damage();
	public static Damage radiation = new Damage();
	public static Damage corrosive = new Damage();
	public static Damage viral = new Damage();

	public static Damage explosiveRaw = new Damage();
	public static Damage explosiveImpact = new Damage();
	public static Damage explosivePuncture = new Damage();
	public static Damage explosiveSlash = new Damage();
	public static Damage explosiveFire = new Damage();
	public static Damage explosiveIce = new Damage();
	public static Damage explosiveElectric = new Damage();
	public static Damage explosiveToxin = new Damage();
	public static Damage explosiveBlast = new Damage();
	public static Damage explosiveMagnetic = new Damage();
	public static Damage explosiveGas = new Damage();
	public static Damage explosiveRadiation = new Damage();
	public static Damage explosiveCorrosive = new Damage();
	public static Damage explosiveViral = new Damage();

	public static SurfaceDamage corpus = new SurfaceDamage();
	public static SurfaceDamage grineer = new SurfaceDamage();
	public static SurfaceDamage infested = new SurfaceDamage();
	public static SurfaceDamage corrupted = new SurfaceDamage();
	public static SurfaceDamage cloneFlesh = new SurfaceDamage();
	public static SurfaceDamage ferrite = new SurfaceDamage();
	public static SurfaceDamage alloy = new SurfaceDamage();
	public static SurfaceDamage mechanical = new SurfaceDamage();
	public static SurfaceDamage corpusFlesh = new SurfaceDamage();
	public static SurfaceDamage shield = new SurfaceDamage();
	public static SurfaceDamage protoShield = new SurfaceDamage();
	public static SurfaceDamage robotic = new SurfaceDamage();
	public static SurfaceDamage infestedFlesh = new SurfaceDamage();
	public static SurfaceDamage fossilized = new SurfaceDamage();
	public static SurfaceDamage sinew = new SurfaceDamage();

	// Bunch of unsorted variables
	public static double impactProcRate;
	public static double punctureProcRate;
	public static double slashProcRate;
	public static double fireProcRate;
	public static double iceProcRate;
	public static double toxinProcRate;
	public static double electricProcRate;
	public static double corrosiveProcRate;
	public static double gasProcRate;
	public static double viralProcRate;
	public static double blastProcRate;
	public static double radiationProcRate;
	public static double magneticProcRate;

	public static double explosiveImpactProcRate;
	public static double explosivePunctureProcRate;
	public static double explosiveSlashProcRate;
	public static double explosiveFireProcRate;
	public static double explosiveIceProcRate;
	public static double explosiveToxinProcRate;
	public static double explosiveElectricProcRate;
	public static double explosiveCorrosiveProcRate;
	public static double explosiveGasProcRate;
	public static double explosiveViralProcRate;
	public static double explosiveBlastProcRate;
	public static double explosiveRadiationProcRate;
	public static double explosiveMagneticProcRate;

	public static double globalToxin;
	public static double globalFire;
	public static double globalElectric;
	public static double globalIce;
	public static double fireRateModPower;
	public static double hunterMunitions;
	public static double vigilante;
	public static double comboCrit;
	public static double comboStatus;
	public static double conditionOverload;
	public static boolean headShot = false;
	public static double bleedDoTDPS;
	public static double electricDoTDPS;
	public static double poisonDoTDPS;
	public static double heatDoTDPS;
	public static double cloudDoTDPS;
	public static double electricProcDPS;
	public static double burstBleedDoTDPS;
	public static double burstPoisonDoTDPS;
	public static double burstHeatDoTDPS;
	public static double burstCloudDoTDPS;
	public static double burstElectricProcDPS;
	public static double burstelectricProcDPS;

	public static boolean updateOutput;

	public static boolean stop = false;
	public static boolean setup = true;
	public static boolean maxxing = false;
	public static boolean quickGroup = false;

	public static double headShotBonus;
	public static double headShotMult;

	public static Combo stanceCombo;
	public static double avgHit;
	public static double avgDelay;

	static double forcedSlashProcs = 0;
	static double forcedImpactProcs = 0;
	static double forcedPunctureProcs = 0;
	static double forcedKnockdownProcs = 0;

	static double COMult = 0;
	static double viralMult = 0;

	/**
	 * ____________________________________________________________ METHODS
	 * ____________________________________________________________
	 */

	/**
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		UIBuilder.UIInit();
		riflePanel = new RiflePanel();
		shotgunPanel = new ShotgunPanel();
		pistolPanel = new PistolPanel();
		arcGunPanel = new ArcGunPanel();
		meleePanel = new MeleePanel();
		theModManager = new ModManagerPanel(riflePanel, shotgunPanel, pistolPanel, meleePanel, arcGunPanel);
		theTTKManager = new TTKManagerPanel();
		theStanceManager = new StanceManagerPanel();
		theWeaponManager = new WeaponManagerPanel(riflePanel, shotgunPanel, pistolPanel, meleePanel, arcGunPanel);
		theColorPanel = new ColorOptionsPanel();
		buildUI();
		mainFrame.setVisible(true);
		setup = false;
		updateTargetList();
		repack();
	}

	/**
	 * Builds the frame UI
	 */
	public static void buildUI() {
		UIBuilder.panelInit(mainPanel);
		UIBuilder.panelInit(secondaryPanel);
		UIBuilder.panelInit(deepsPanel);
		UIBuilder.panelInit(topPanel);
		UIBuilder.panelInit(bottomPanel);
		UIBuilder.panelInit(riflePanel);
		UIBuilder.panelInit(shotgunPanel);
		UIBuilder.panelInit(pistolPanel);
		UIBuilder.panelInit(meleePanel);
		UIBuilder.panelInit(arcGunPanel);
		UIBuilder.buttonInit(calculateButton);
		UIBuilder.buttonInit(maximizeButton);
		UIBuilder.buttonInit(stopButton);
		UIBuilder.buttonInit(quickTargetButton);
		UIBuilder.buttonInit(removeTargetButton);
		UIBuilder.labelInit(TTKIterationsLabel);
		UIBuilder.labelInit(targetLevelLabel);
		UIBuilder.labelInit(loadingLabel);
		UIBuilder.numberFieldInit(TTKIterationsField);
		UIBuilder.numberFieldInit(targetLevelField);
		UIBuilder.buttonInit(clearOutputButton);
		UIBuilder.textAreaInit(output);
		UIBuilder.scrollPaneInit(outputScroll);
		UIBuilder.tabbedPaneInit(weaponPane);
		UIBuilder.menuBarInit(mainMenuBar);
		UIBuilder.menuInit(fileMenu);
		UIBuilder.menuItemInit(modMenu);
		UIBuilder.menuItemInit(TTKMenu);
		UIBuilder.menuItemInit(weaponMenu);
		UIBuilder.menuItemInit(stanceMenu);
		UIBuilder.menuItemInit(saveItem);
		UIBuilder.menuItemInit(loadItem);
		UIBuilder.menuItemInit(colorOptionsItem);
		UIBuilder.fileChooserInit(chooser);
		UIBuilder.checkBoxInit(headShots);
		UIBuilder.checkBoxInit(smartMax);
		UIBuilder.labelInit(corrosiveProjectionLabel);
		UIBuilder.labelInit(shieldDisruptionLabel);
		UIBuilder.labelInit(targetGroupLabel);
		UIBuilder.comboBoxInit(corrosiveProjectionBox);
		UIBuilder.comboBoxInit(shieldDisruptionBox);
		UIBuilder.comboBoxInit(targetGroupBox);
		UIBuilder.listInit(enemyList);

		enemyList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		enemyList.setLayoutOrientation(JList.VERTICAL_WRAP);
		enemyList.setVisibleRowCount(-1);

		corrosiveProjectionBox.setPrototypeDisplayValue("XX");
		shieldDisruptionBox.setPrototypeDisplayValue("XX");
		targetGroupBox.setPrototypeDisplayValue("XX");

		for (int i = 0; i < 10; i++) {
			targetGroupBox.addItem("" + i);
		}

		for (int i = 0; i < 5; i++) {
			corrosiveProjectionBox.addItem("" + i);
		}
		for (int i = 0; i < 5; i++) {
			shieldDisruptionBox.addItem("" + i);
		}

		try {
			File currentDirectory = new File(".");
			chooser.setCurrentDirectory(currentDirectory);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;

		calculateButton.addActionListener(action);
		maximizeButton.addActionListener(action);
		stopButton.addActionListener(action);
		quickTargetButton.addActionListener(action);
		removeTargetButton.addActionListener(action);
		clearOutputButton.addActionListener(action);
		saveItem.addActionListener(action);
		loadItem.addActionListener(action);
		modMenu.addActionListener(action);
		TTKMenu.addActionListener(action);
		weaponMenu.addActionListener(action);
		stanceMenu.addActionListener(action);
		colorOptionsItem.addActionListener(action);
		headShots.addActionListener(action);
		targetGroupBox.addActionListener(action);
		weaponPane.addChangeListener(change);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		secondaryPanel.setLayout(new BoxLayout(secondaryPanel, BoxLayout.X_AXIS));
		deepsPanel.setLayout(new BoxLayout(deepsPanel, BoxLayout.Y_AXIS));
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));

		weaponPane.add(riflePanel, Constants.RIFLE);
		weaponPane.add(shotgunPanel, Constants.SHOTGUN);
		weaponPane.add(pistolPanel, Constants.PISTOL);
		weaponPane.add(meleePanel, Constants.MELEE);
		weaponPane.add(arcGunPanel, Constants.ARCHGUN);

		JPanel targetButtonPanel = new JPanel();
		UIBuilder.panelInit(targetButtonPanel);
		targetButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		targetButtonPanel.add(targetGroupLabel);
		targetButtonPanel.add(targetGroupBox);
		targetButtonPanel.add(targetLevelLabel);
		targetButtonPanel.add(targetLevelField);
		targetButtonPanel.add(quickTargetButton);
		targetButtonPanel.add(removeTargetButton);

		JPanel buttonPanel = new JPanel();
		UIBuilder.panelInit(buttonPanel);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(corrosiveProjectionLabel);
		buttonPanel.add(corrosiveProjectionBox);
		buttonPanel.add(shieldDisruptionLabel);
		buttonPanel.add(shieldDisruptionBox);
		buttonPanel.add(headShots);
		buttonPanel.add(TTKIterationsLabel);
		buttonPanel.add(TTKIterationsField);
		buttonPanel.add(calculateButton);
		buttonPanel.add(maximizeButton);
		buttonPanel.add(clearOutputButton);
		buttonPanel.add(smartMax);

		headShots.setToolTipText("Calcualtes TTK as if you are getting only headshots. Not related to effects triggered by headshots.");
		corrosiveProjectionLabel.setToolTipText("Number of Corrosive Projection auras active.");
		corrosiveProjectionBox.setToolTipText("Number of Corrosive Projection auras active.");
		shieldDisruptionLabel.setToolTipText("Number of Shield Disruption auras active.");
		shieldDisruptionBox.setToolTipText("Number of Shield Disruption auras active.");
		targetGroupLabel.setToolTipText("Target group to run calculations against.");
		targetGroupBox.setToolTipText("Target group to run calculations against.");
		TTKIterationsField.setToolTipText("Set the number of TTK simulation iterations. 10000 by defautl, 1000 for lightweight TTK.");
		TTKIterationsLabel.setToolTipText("Set the number of TTK simulation iterations. 10000 by defautl, 1000 for lightweight TTK.");
		maximizeButton.setToolTipText("Test every combination of mods in empty mod slots for the best builds. Will take time to complete");
		targetLevelLabel.setToolTipText("Override the default level");
		targetLevelField.setToolTipText("Override the default level");
		quickTargetButton.setToolTipText("Add targets to the current group");
		removeTargetButton.setToolTipText("Remove selected target from the current group");
		smartMax.setToolTipText("Allows the maximizer to skip bad builds. Disable if you want complete results");

		JPanel bottomRightPanel = new JPanel();
		UIBuilder.panelInit(bottomRightPanel);
		bottomRightPanel.setLayout(new BoxLayout(bottomRightPanel, BoxLayout.Y_AXIS));
		bottomRightPanel.add(outputScroll);
		bottomRightPanel.add(buttonPanel);

		JPanel bottomLeftPanel = new JPanel();
		JPanel bottomLeftFillPanel = new JPanel();
		bottomLeftFillPanel.setLayout(new GridBagLayout());
		UIBuilder.panelInit(bottomLeftPanel);
		bottomLeftPanel.setLayout(new BoxLayout(bottomLeftPanel, BoxLayout.Y_AXIS));
		bottomLeftFillPanel.add(enemyList, gbc);
		bottomLeftPanel.add(bottomLeftFillPanel);
		bottomLeftPanel.add(targetButtonPanel, gbc);
		UIBuilder.panelInit(bottomLeftFillPanel);

		outputScroll.getViewport().setPreferredSize(new Dimension(850, 250));
		bottomLeftFillPanel.setPreferredSize(new Dimension(300, 250));
		buttonPanel.setSize(new Dimension(200, 30));
		targetLevelField.setPreferredSize(new Dimension(0, 24));
		TTKIterationsField.setPreferredSize(new Dimension(0, 24));

		topPanel.add(weaponPane);
		bottomPanel.add(bottomLeftPanel);
		bottomPanel.add(bottomRightPanel);
		mainPanel.add(topPanel);
		mainPanel.add(bottomPanel);

		mainPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		DPSPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		secondaryPanel.add(mainPanel);
		secondaryPanel.add(DPSPanel);

		fileMenu.add(colorOptionsItem);
		fileMenu.add(saveItem);
		fileMenu.add(loadItem);
		mainMenuBar.add(fileMenu);

		mainMenuBar.add(modMenu);
		mainMenuBar.add(TTKMenu);
		mainMenuBar.add(weaponMenu);
		mainMenuBar.add(stanceMenu);

		mainFrame.setJMenuBar(mainMenuBar);
		mainFrame.add(secondaryPanel);
		mainFrame.pack();
		mainFrame.addWindowListener(window);
		mainFrame.setTitle(Constants.APP_TITLE + " " + Constants.APP_VERSION);
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		smartMax.setSelected(false);

		// Loading screen
		progressBar = new JProgressBar(0, 100);
		progressBar.setBackground(Color.BLACK);
		progressBar.setForeground(Color.GREEN);
		loadingLabel.setFont(new Font("Verdana", Font.PLAIN, 100));
		loadingScreen.setLayout(new GridBagLayout());
		JPanel loadingStats = new JPanel();
		JPanel loadingBackground = new JPanel();
		loadingBackground.setBackground(new Color(0, 0, 0, 180));
		loadingStats.setOpaque(false);
		loadingBackground.setLayout(new GridBagLayout());
		loadingStats.setLayout(new BoxLayout(loadingStats, BoxLayout.Y_AXIS));
		loadingStats.add(loadingLabel);
		loadingStats.add(progressBar);
		JPanel stopPanel = new JPanel();
		stopPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		stopPanel.add(stopButton);
		stopPanel.setOpaque(false);
		loadingStats.add(stopPanel);
		loadingStats.setBackground(new Color(0, 0, 0, 0));
		loadingBackground.add(loadingStats);
		loadingScreen.add(loadingBackground, gbc);
		loadingScreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				e.consume();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				e.consume();
			}
		});

		TTKIterationsField.setText("10000");

		UIBuilder.createTitledLineBorder(DPSPanel.stats, "CALCULATED STATS");
		UIBuilder.createTitledLineBorder(DPSPanel.status, "STATUS BREAKDOWN");
		UIBuilder.createTitledLineBorder(bottomLeftFillPanel, "TARGETS");
	}

	/**
	 * Calculates and Displays the DPS
	 */
	public static void calculateDPS() {
		// Clear all the previous values
		clearValues();

		// Get the Selected Weapon Type and Active Mods
		selectedWeapon = (WeaponPanel) weaponPane.getSelectedComponent();
		// selectedWeapon.parseActiveMods();

		// Get the base values from the selected weapon
		getBaseValues();

		// Calculate the final values based on weapon parameters and Active Mods
		calculateFinals();

		// Calculate miscellaneous values
		calculateMiscValues();

		// Calculate damage per shot
		calculateDamagePerShot();

		// Calculate the damage per magazine
		calculateDamagePerIteration();

		// Calculate the damage per minute
		calculateDamagePerMinute();

		// Calculate the damage per second
		calculateDamagePerSecond();

		// Calculate the burst damage per second
		calculateBurstDamagePerSecond();

		// Calculate Time To Kill Values
		String iters = TTKIterationsField.getText();
		if (iters == null) {
			iters = "10000";
		}
		complexTTKIterations = Integer.parseInt(iters);

		if (useComplexTTK && raw.perSecond > 100) {
			int targetGroup = Integer.parseInt((String) targetGroupBox.getSelectedItem());
			groupTargets = new Vector<TTKTarget>();
			for (TTKTarget target : theTTKManager.targets) {
				if (target.groups.contains(targetGroup)) {
					groupTargets.add(target);
				}
			}
			// complexTTKCompletions = 0;
			for (TTKTarget target : groupTargets) {
				target.runAdvancedTTK();
				String name = target.name + "[" + target.currentLevel + "]";
				if (name.length() > longestTTKName.length()) {
					longestTTKName = name;
				}
			}
		}
		// Print the data to the text area and render the graph
		if (updateOutput) {
			updateOutput();
		}
	}

	public static void updateTargetList() {
		enemyListModel.clear();
		int targetGroup = Integer.parseInt((String) targetGroupBox.getSelectedItem());
		groupTargets = new Vector<TTKTarget>();
		for (TTKTarget target : theTTKManager.targets) {
			if (target.groups.contains(targetGroup)) {
				enemyListModel.addElement(target.name);
			}
		}
		repack();
	}

	/**
	 * Clears all values
	 */
	public static void clearValues() {
		selectedWeapon = null;
		activeMods = new Vector<Mod>();
		modRanks = new Vector<Integer>();
		weaponName = "";
		weaponMode = "";
		damageType = "";
		damage2Type = "";
		explosiveDamage1Type = "";
		explosiveDamage2Type = "";
		chargeTime = 0.0;
		drain = 0;
		raw.clear();
		impact.clear();
		puncture.clear();
		slash.clear();
		fire.clear();
		ice.clear();
		electric.clear();
		toxin.clear();
		blast.clear();
		magnetic.clear();
		gas.clear();
		radiation.clear();
		corrosive.clear();
		viral.clear();
		explosiveRaw.clear();
		explosiveImpact.clear();
		explosivePuncture.clear();
		explosiveSlash.clear();
		explosiveFire.clear();
		explosiveIce.clear();
		explosiveElectric.clear();
		explosiveToxin.clear();
		explosiveBlast.clear();
		explosiveMagnetic.clear();
		explosiveGas.clear();
		explosiveRadiation.clear();
		explosiveCorrosive.clear();
		explosiveViral.clear();
		corpus.clear();
		grineer.clear();
		infested.clear();
		corrupted.clear();
		cloneFlesh.clear();
		ferrite.clear();
		alloy.clear();
		mechanical.clear();
		corpusFlesh.clear();
		shield.clear();
		protoShield.clear();
		robotic.clear();
		infestedFlesh.clear();
		fossilized.clear();
		sinew.clear();
		fireRate = 0.0;
		reloadTime = 0.0;
		critChance = 0.0;
		critMult = 0.0;
		projectileCount = 0.0;
		firstShotDamageMult = 1.0;
		lastShotDamageMult = 1.0;
		statusChance = 0.0;
		statusDuration = 1.0;
		damageMult = 1.0;
		deadAimMult = 1.0;
		flatDamageBonus = 0.0;
		mag = 0;
		combo = 0;
		startingCombo = 1;
		burstCount = 0;
		finalMag = 0;
		finalAmmo = 0;
		finalIterationTime = 0.0;
		finalIterationsPerMinute = 0.0;
		averageCritMult = 0;
		finalCritChance = 0.0;
		finalCritMult = 0.0;
		finalFireRate = 0.0;
		finalReloadTime = 0.0;
		finalProjectileCount = 0.0;
		finalFirstShotDamageMult = 1.0;
		finalLastShotDamageMult = 1.0;
		finalStatusChance = 0.0;
		finalStatusDuration = 0.0;
		finalDamageMult = 1.0;
		finalDeadAimMult = 1.0;
		finalFlatDamageBonus = 0.0;
		finalCorpusMult = 1.0;
		finalGrineerMult = 1.0;
		finalInfestedMult = 1.0;
		finalCorruptedMult = 1.0;
		procsPerSecond = 0.0;
		burstProcsPerSecond = 0.0;
		slashStacks = 0;
		fireStacks = 0;
		toxinStacks = 0;
		gasStacks = 0;
		burstSlashStacks = 0;
		burstFireStacks = 0;
		burstToxinStacks = 0;
		burstGasStacks = 0;
		// complexTTKCompletions = 0;
		globalFire = 0;
		globalToxin = 0;
		globalElectric = 0;
		globalIce = 0;
		hunterMunitions = 0;
		vigilante = 0;
		comboCrit = 0;
		comboStatus = 0;
		conditionOverload = 0;
		groupTargets = null;
		headShotBonus = 1;
		headShotMult = 1;
		stanceCombo = null;
		avgHit = 1;
		avgDelay = 1;
		shatteringImpact = 0;
		explosiveSlashProcRate = 0;
		explosiveFireProcRate = 0;
		explosiveToxinProcRate = 0;
		explosiveGasProcRate = 0;
		explosiveElectricProcRate = 0;
		explosiveImpactProcRate = 0;
		explosivePunctureProcRate = 0;
		explosiveIceProcRate = 0;
		explosiveCorrosiveProcRate = 0;
		explosiveViralProcRate = 0;
		explosiveBlastProcRate = 0;
		explosiveRadiationProcRate = 0;
		explosiveMagneticProcRate = 0;
		forcedSlashProcs = 0;
		forcedImpactProcs = 0;
		forcedPunctureProcs = 0;
		forcedKnockdownProcs = 0;
		COMult = 0;
		finalComboCrit = 0.0;
		averageStatusChance = 0;
		viralMult = 1;
		forcedProc = "";
	}

	/**
	 * Gets the base values from the selected weapon
	 */
	protected static void getBaseValues() {
		// Base Values
		weaponName = selectedWeapon.getName();
		weaponMode = selectedWeapon.getWeaponMode();
		damageType = selectedWeapon.getDamageType();
		chargeTime = selectedWeapon.getChargeTime();
		fireRate = selectedWeapon.getFireRate();
		reloadTime = selectedWeapon.getReloadTime();
		critChance = selectedWeapon.getCritChance();
		critMult = selectedWeapon.getCritMultiplier();
		projectileCount = selectedWeapon.getProjectiles();
		firstShotDamageMult = 1;
		lastShotDamageMult = 1;
		statusChance = selectedWeapon.getStatusChance();
		mag = selectedWeapon.getMagSize();
		if (selectedWeapon.weaponType.equals(Constants.MELEE)) {
			stanceCombo = selectedWeapon.getStanceCombo();
			combo = 5;
		} else {
			combo = selectedWeapon.getCombo();
		}
		startingCombo = selectedWeapon.getStartingCombo();
		burstCount = selectedWeapon.getBurstCount();
		drain = selectedWeapon.getDrain();
		impact.base = selectedWeapon.getImpactDamage();
		puncture.base = selectedWeapon.getPunctureDamage();
		slash.base = selectedWeapon.getSlashDamage();
		explosiveImpact.base = selectedWeapon.getExplosiveImpactDamage();
		explosivePuncture.base = selectedWeapon.getExplosivePunctureDamage();
		explosiveSlash.base = selectedWeapon.getExplosiveSlashDamage();

		damage2Type = selectedWeapon.getDamage2Type();
		explosiveDamage1Type = selectedWeapon.getExplosiveDamage1Type();
		explosiveDamage2Type = selectedWeapon.getExplosiveDamage2Type();

		forcedProc = selectedWeapon.getForcedProcType();
		
		switch (damageType) {
		case Constants.FIRE_WEAPON_DAMAGE:
			fire.base = selectedWeapon.getBaseDamage();
			break;
		case Constants.ICE_WEAPON_DAMAGE:
			ice.base = selectedWeapon.getBaseDamage();
			break;
		case Constants.ELECTRIC_WEAPON_DAMAGE:
			electric.base = selectedWeapon.getBaseDamage();
			break;
		case Constants.TOXIN_WEAPON_DAMAGE:
			toxin.base = selectedWeapon.getBaseDamage();
			break;
		case Constants.BLAST_WEAPON_DAMAGE:
			blast.base = selectedWeapon.getBaseDamage();
			break;
		case Constants.MAGNETIC_WEAPON_DAMAGE:
			magnetic.base = selectedWeapon.getBaseDamage();
			break;
		case Constants.GAS_WEAPON_DAMAGE:
			gas.base = selectedWeapon.getBaseDamage();
			break;
		case Constants.RADIATION_WEAPON_DAMAGE:
			radiation.base = selectedWeapon.getBaseDamage();
			break;
		case Constants.CORROSIVE_WEAPON_DAMAGE:
			corrosive.base = selectedWeapon.getBaseDamage();
			break;
		case Constants.VIRAL_WEAPON_DAMAGE:
			viral.base = selectedWeapon.getBaseDamage();
			break;
		}

		switch (damage2Type) {
		case Constants.FIRE_WEAPON_DAMAGE:
			fire.base = selectedWeapon.getBaseDamage2();
			break;
		case Constants.ICE_WEAPON_DAMAGE:
			ice.base = selectedWeapon.getBaseDamage2();
			break;
		case Constants.ELECTRIC_WEAPON_DAMAGE:
			electric.base = selectedWeapon.getBaseDamage2();
			break;
		case Constants.TOXIN_WEAPON_DAMAGE:
			toxin.base = selectedWeapon.getBaseDamage2();
			break;
		case Constants.BLAST_WEAPON_DAMAGE:
			blast.base = selectedWeapon.getBaseDamage2();
			break;
		case Constants.MAGNETIC_WEAPON_DAMAGE:
			magnetic.base = selectedWeapon.getBaseDamage2();
			break;
		case Constants.GAS_WEAPON_DAMAGE:
			gas.base = selectedWeapon.getBaseDamage2();
			break;
		case Constants.RADIATION_WEAPON_DAMAGE:
			radiation.base = selectedWeapon.getBaseDamage2();
			break;
		case Constants.CORROSIVE_WEAPON_DAMAGE:
			corrosive.base = selectedWeapon.getBaseDamage2();
			break;
		case Constants.VIRAL_WEAPON_DAMAGE:
			viral.base = selectedWeapon.getBaseDamage2();
			break;
		}

		switch (explosiveDamage1Type) {
		case Constants.FIRE_WEAPON_DAMAGE:
			explosiveFire.base = selectedWeapon.getExplosiveBaseDamage();
			break;
		case Constants.ICE_WEAPON_DAMAGE:
			explosiveIce.base = selectedWeapon.getExplosiveBaseDamage();
			break;
		case Constants.ELECTRIC_WEAPON_DAMAGE:
			explosiveElectric.base = selectedWeapon.getExplosiveBaseDamage();
			break;
		case Constants.TOXIN_WEAPON_DAMAGE:
			explosiveToxin.base = selectedWeapon.getExplosiveBaseDamage();
			break;
		case Constants.BLAST_WEAPON_DAMAGE:
			explosiveBlast.base = selectedWeapon.getExplosiveBaseDamage();
			break;
		case Constants.MAGNETIC_WEAPON_DAMAGE:
			explosiveMagnetic.base = selectedWeapon.getExplosiveBaseDamage();
			break;
		case Constants.GAS_WEAPON_DAMAGE:
			explosiveGas.base = selectedWeapon.getExplosiveBaseDamage();
			break;
		case Constants.RADIATION_WEAPON_DAMAGE:
			explosiveRadiation.base = selectedWeapon.getExplosiveBaseDamage();
			break;
		case Constants.CORROSIVE_WEAPON_DAMAGE:
			explosiveCorrosive.base = selectedWeapon.getExplosiveBaseDamage();
			break;
		case Constants.VIRAL_WEAPON_DAMAGE:
			explosiveViral.base = selectedWeapon.getExplosiveBaseDamage();
			break;
		}

		switch (explosiveDamage2Type) {
		case Constants.FIRE_WEAPON_DAMAGE:
			explosiveFire.base = selectedWeapon.getExplosiveBaseDamage2();
			break;
		case Constants.ICE_WEAPON_DAMAGE:
			explosiveIce.base = selectedWeapon.getExplosiveBaseDamage2();
			break;
		case Constants.ELECTRIC_WEAPON_DAMAGE:
			explosiveElectric.base = selectedWeapon.getExplosiveBaseDamage2();
			break;
		case Constants.TOXIN_WEAPON_DAMAGE:
			explosiveToxin.base = selectedWeapon.getExplosiveBaseDamage2();
			break;
		case Constants.BLAST_WEAPON_DAMAGE:
			explosiveBlast.base = selectedWeapon.getExplosiveBaseDamage2();
			break;
		case Constants.MAGNETIC_WEAPON_DAMAGE:
			explosiveMagnetic.base = selectedWeapon.getExplosiveBaseDamage2();
			break;
		case Constants.GAS_WEAPON_DAMAGE:
			explosiveGas.base = selectedWeapon.getExplosiveBaseDamage2();
			break;
		case Constants.RADIATION_WEAPON_DAMAGE:
			explosiveRadiation.base = selectedWeapon.getExplosiveBaseDamage2();
			break;
		case Constants.CORROSIVE_WEAPON_DAMAGE:
			explosiveCorrosive.base = selectedWeapon.getExplosiveBaseDamage2();
			break;
		case Constants.VIRAL_WEAPON_DAMAGE:
			explosiveViral.base = selectedWeapon.getExplosiveBaseDamage2();
			break;
		}

		raw.base = impact.base + puncture.base + slash.base + fire.base + ice.base + electric.base + toxin.base + blast.base + magnetic.base + gas.base + radiation.base + corrosive.base + viral.base;
		explosiveRaw.base = explosiveImpact.base + explosivePuncture.base + explosiveSlash.base + explosiveFire.base + explosiveIce.base + explosiveElectric.base + explosiveToxin.base + explosiveBlast.base + explosiveMagnetic.base + explosiveGas.base + explosiveRadiation.base
				+ explosiveCorrosive.base + explosiveViral.base;

		// Factor for multiple projectiles per shot
		if (projectileCount > 1.0) {
			raw.base /= projectileCount;
			impact.base /= projectileCount;
			puncture.base /= projectileCount;
			slash.base /= projectileCount;
			fire.base /= projectileCount;
			ice.base /= projectileCount;
			electric.base /= projectileCount;
			toxin.base /= projectileCount;
			blast.base /= projectileCount;
			magnetic.base /= projectileCount;
			gas.base /= projectileCount;
			radiation.base /= projectileCount;
			corrosive.base /= projectileCount;
			viral.base /= projectileCount;

			explosiveRaw.base /= projectileCount;
			explosiveImpact.base /= projectileCount;
			explosivePuncture.base /= projectileCount;
			explosiveSlash.base /= projectileCount;
			explosiveFire.base /= projectileCount;
			explosiveIce.base /= projectileCount;
			explosiveElectric.base /= projectileCount;
			explosiveToxin.base /= projectileCount;
			explosiveBlast.base /= projectileCount;
			explosiveMagnetic.base /= projectileCount;
			explosiveGas.base /= projectileCount;
			explosiveRadiation.base /= projectileCount;
			explosiveCorrosive.base /= projectileCount;
			explosiveViral.base /= projectileCount;
		}
		// Mod Vectors
		if (maxxing) {
			activeMods = theMaximizer.simulatedMods;
			modRanks = theMaximizer.simulatedRanks;
		} else {
			activeMods = selectedWeapon.getActiveMods();
			modRanks = selectedWeapon.getActiveModRanks();
		}
	}

	/**
	 * Calculates the final modded values
	 */
	protected static void calculateFinals() {
		// Initialize mod vectors
		Vector<Double> magMods = new Vector<Double>();
		Vector<Double> critChanceMods = new Vector<Double>();
		Vector<Double> addCritChanceMods = new Vector<Double>();
		Vector<Double> critMultMods = new Vector<Double>();
		Vector<Double> fireRateMods = new Vector<Double>();
		Vector<Double> multiplicativeFireRateMods = new Vector<Double>();
		Vector<Double> reloadTimeMods = new Vector<Double>();
		Vector<Double> damageMultMods = new Vector<Double>();
		Vector<Double> impactDamageMods = new Vector<Double>();
		Vector<Double> punctureDamageMods = new Vector<Double>();
		Vector<Double> slashDamageMods = new Vector<Double>();
		Vector<Double> fireDamageMods = new Vector<Double>();
		Vector<Double> iceDamageMods = new Vector<Double>();
		Vector<Double> electricDamageMods = new Vector<Double>();
		Vector<Double> toxinDamageMods = new Vector<Double>();
		Vector<Double> blastDamageMods = new Vector<Double>();
		Vector<Double> magneticDamageMods = new Vector<Double>();
		Vector<Double> gasDamageMods = new Vector<Double>();
		Vector<Double> radiationDamageMods = new Vector<Double>();
		Vector<Double> corrosiveDamageMods = new Vector<Double>();
		Vector<Double> viralDamageMods = new Vector<Double>();

		Vector<Double> explosiveFireDamageMods = new Vector<Double>();
		Vector<Double> explosiveIceDamageMods = new Vector<Double>();
		Vector<Double> explosiveElectricDamageMods = new Vector<Double>();
		Vector<Double> explosiveToxinDamageMods = new Vector<Double>();
		Vector<Double> explosiveBlastDamageMods = new Vector<Double>();
		Vector<Double> explosiveMagneticDamageMods = new Vector<Double>();
		Vector<Double> explosiveGasDamageMods = new Vector<Double>();
		Vector<Double> explosiveRadiationDamageMods = new Vector<Double>();
		Vector<Double> explosiveCorrosiveDamageMods = new Vector<Double>();
		Vector<Double> explosiveViralDamageMods = new Vector<Double>();

		Vector<Double> projectileCountMods = new Vector<Double>();
		Vector<Double> firstShotDamageMods = new Vector<Double>();
		Vector<Double> lastShotDamageMods = new Vector<Double>();
		Vector<Double> statusChanceMods = new Vector<Double>();
		Vector<Double> statusDurationMods = new Vector<Double>();
		Vector<Double> corpusMods = new Vector<Double>();
		Vector<Double> grineerMods = new Vector<Double>();
		Vector<Double> infestedMods = new Vector<Double>();
		Vector<Double> corruptedMods = new Vector<Double>();
		Vector<Double> flatDamageMods = new Vector<Double>();
		Vector<Double> deadAimMods = new Vector<Double>();
		Vector<Double> flatStatusMods = new Vector<Double>();
		Vector<Double> flatMagMods = new Vector<Double>();
		Vector<String> elements = new Vector<String>(); // Ordered element vector
		Vector<String> elements2 = new Vector<String>(); // Ordered element vector for the explosion

		// Populate mod vectors
		for (int i = 0; i < activeMods.size(); i++) {
			Mod tempMod = activeMods.get(i);
			if (tempMod != null) {
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_MAG_CAP)) {
					magMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_MAG_CAP))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_CRIT_CHANCE)) {
					critChanceMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_CRIT_CHANCE))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_CRIT_MULTIPLIER)) {
					critMultMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_CRIT_MULTIPLIER))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_FIRE_RATE)) {
					fireRateMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_FIRE_RATE))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_MULTI_RATE)) {
					multiplicativeFireRateMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_MULTI_RATE))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_RELOAD_SPEED)) {
					reloadTimeMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_RELOAD_SPEED))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_DAMAGE_BONUS)) {
					damageMultMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_DAMAGE_BONUS))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_MULTISHOT)) {
					projectileCountMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_MULTISHOT))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_FIRST_SHOT_DAMAGE)) {
					firstShotDamageMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_FIRST_SHOT_DAMAGE))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_LAST_SHOT_DAMAGE)) {
					lastShotDamageMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_LAST_SHOT_DAMAGE))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_STATUS_CHANCE)) {
					statusChanceMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_STATUS_CHANCE))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_STATUS_DURATION)) {
					statusDurationMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_STATUS_DURATION))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_CORPUS_DAMAGE)) {
					corpusMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_CORPUS_DAMAGE))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_GRINEER_DAMAGE)) {
					grineerMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_GRINEER_DAMAGE))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_CORRUPTED_DAMAGE)) {
					corruptedMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_CORRUPTED_DAMAGE))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_INFESTED_DAMAGE)) {
					infestedMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_INFESTED_DAMAGE))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_FLAT_DAMAGE)) {
					flatDamageMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_FLAT_DAMAGE))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_FLAT_STATUS)) {
					flatStatusMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_FLAT_STATUS))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_FLAT_MAG)) {
					flatMagMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_FLAT_MAG))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_DEAD_AIM)) {
					deadAimMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_DEAD_AIM))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_MUNITIONS)) {
					hunterMunitions = tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_MUNITIONS)) * (1.0 + modRanks.get(i));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_IMPACT_DAMAGE)) {
					impactDamageMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_IMPACT_DAMAGE))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_PUNCTURE_DAMAGE)) {
					punctureDamageMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_PUNCTURE_DAMAGE))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_SLASH_DAMAGE)) {
					slashDamageMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_SLASH_DAMAGE))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_LIGHTNING_DAMAGE)) {
					double modPower = tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_LIGHTNING_DAMAGE)) * (1.0 + modRanks.get(i));
					globalElectric += modPower;
					if (!elements.contains("Electric"))
						elements.add("Electric");
					if (!elements2.contains("Electric"))
						elements2.add("Electric");
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_FIRE_DAMAGE)) {
					double modPower = tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_FIRE_DAMAGE)) * (1.0 + modRanks.get(i));
					globalFire += modPower;
					if (!elements.contains("Fire"))
						elements.add("Fire");
					if (!elements2.contains("Fire"))
						elements2.add("Fire");
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_TOXIN_DAMAGE)) {
					double modPower = tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_TOXIN_DAMAGE)) * (1.0 + modRanks.get(i));
					globalToxin += modPower;
					if (!elements.contains("Toxin"))
						elements.add("Toxin");
					if (!elements2.contains("Toxin"))
						elements2.add("Toxin");
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_ICE_DAMAGE)) {
					double modPower = tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_ICE_DAMAGE)) * (1.0 + modRanks.get(i));
					globalIce += modPower;
					if (!elements.contains("Ice"))
						elements.add("Ice");
					if (!elements2.contains("Ice"))
						elements2.add("Ice");
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_VIGILANTE)) {
					vigilante += 1;
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_COMBO_CRIT)) {
					double modPower = tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_COMBO_CRIT)) * (1.0 + modRanks.get(i));
					comboCrit += modPower;
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_COMBO_STATUS)) {
					double modPower = tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_COMBO_STATUS)) * (1.0 + modRanks.get(i));
					comboStatus += modPower;
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_CONDITION_OVERLOAD)) {
					double modPower = tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_CONDITION_OVERLOAD)) * (1.0 + modRanks.get(i));
					conditionOverload += modPower;
				}
				if (tempMod.effectTypes.contains(Constants.HEADSHOT_BONUS)) {
					headShotBonus += ((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.HEADSHOT_BONUS))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_ADDITIVE_CC)) {
					addCritChanceMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_ADDITIVE_CC))) * (1.0 + modRanks.get(i)));
				}
				if (tempMod.effectTypes.contains(Constants.MOD_TYPE_SHATTERING_IMPACT)) {
					shatteringImpact += (1.0 + modRanks.get(i));
				}
			}
		}

		// Mutalist Quanta: get bubble counts
		int mQ1 = 0;
		int mQ2 = 0;
		int mQ3 = 0;
		try {
			mQ1 = Integer.parseInt(selectedWeapon.mQ1Field.getText());
		} catch (Exception e) {
		}
		try {
			mQ2 = Integer.parseInt(selectedWeapon.mQ2Field.getText());
		} catch (Exception e) {
		}
		try {
			mQ3 = Integer.parseInt(selectedWeapon.mQ3Field.getText());
		} catch (Exception e) {
		}

		// Mutalist Quanta: If innate heat, the innate element combines before
		// M.Quanta's added electric
		if (damageType.equals("Fire")) {
			if (!elements.contains(damageType) && selectedWeapon.getBaseDamage() > 0)
				elements.add(damageType);
		}
		if (damage2Type.equals("Fire")) {
			if (!elements.contains(damage2Type) && selectedWeapon.getBaseDamage2() > 0)
				elements.add(damage2Type);
		}
		if (explosiveDamage1Type.equals("Fire")) {
			if (!elements2.contains(explosiveDamage1Type) && selectedWeapon.getExplosiveBaseDamage() > 0)
				elements2.add(explosiveDamage1Type);
		}
		if (explosiveDamage2Type.equals("Fire")) {
			if (!elements2.contains(explosiveDamage2Type) && selectedWeapon.getExplosiveBaseDamage2() > 0)
				elements2.add(explosiveDamage2Type);
		}

		// Mutalist Quanta: If NOT hitscan, add element to be combined
		if ((mQ1 > 0 || mQ2 > 0 || mQ3 > 0) && !selectedWeapon.mQCombineElement.isSelected()) {

			globalElectric += mQ1;
			globalElectric += mQ2 * 3.65;
			globalElectric += mQ3 * 5;

			if (!elements.contains("Electric")) {
				elements.add("Electric");
			}
			if (!elements2.contains("Electric")) {
				elements2.add("Electric");
			}
		}

		if (!damageType.equals("Fire")) {
			if (!elements.contains(damageType) && selectedWeapon.getBaseDamage() > 0)
				if (damageType.equals("Ice") || damageType.equals("Toxin") || damageType.equals("Electric")) {
					elements.add(damageType);
				}
		}
		if (!damage2Type.equals("Fire")) {
			if (!elements.contains(damage2Type) && selectedWeapon.getBaseDamage2() > 0)
				if (damage2Type.equals("Ice") || damage2Type.equals("Toxin") || damage2Type.equals("Electric")) {
					elements.add(damage2Type);
				}
		}
		if (!explosiveDamage1Type.equals("Fire")) {
			if (!elements2.contains(explosiveDamage1Type) && selectedWeapon.getExplosiveBaseDamage() > 0)
				if (explosiveDamage1Type.equals("Ice") || explosiveDamage1Type.equals("Toxin") || explosiveDamage1Type.equals("Electric")) {
					elements2.add(explosiveDamage1Type);
				}
		}
		if (!explosiveDamage2Type.equals("Fire")) {
			if (!elements2.contains(explosiveDamage2Type) && selectedWeapon.getExplosiveBaseDamage2() > 0)
				if (explosiveDamage2Type.equals("Ice") || explosiveDamage2Type.equals("Toxin") || explosiveDamage2Type.equals("Electric")) {
					elements2.add(explosiveDamage2Type);
				}
		}

		// Combine elements
		for (int i = 0; i < elements.size() - 1; i++) {
			String element1 = elements.get(i);
			String element2 = elements.get(i + 1);
			if ((element1.equals("Fire") || element1.equals("Ice") || element1.equals("Toxin") || element1.equals("Electric")) && (element2.equals("Fire") || element2.equals("Ice") || element2.equals("Toxin") || element2.equals("Electric"))) {

				if ((element1.equals("Fire") && element2.equals("Ice")) || (element1.equals("Ice") && element2.equals("Fire"))) {
					elements.add("Blast");
					blastDamageMods.add(globalFire + globalIce);
					if (damageType.equals("Fire") || damageType.equals("Ice") || damage2Type.equals("Fire") || damage2Type.equals("Ice")) {
						blastDamageMods.add(fire.base / raw.base);
						blastDamageMods.add(ice.base / raw.base);
						fire.base = 0.0;
						ice.base = 0.0;
					}
				} else if ((element1.equals("Electric") && element2.equals("Toxin")) || (element1.equals("Toxin") && element2.equals("Electric"))) {
					elements.add("Corrosive");
					corrosiveDamageMods.add(globalElectric + globalToxin);
					if (damageType.equals("Electric") || damageType.equals("Toxin") || damage2Type.equals("Electric") || damage2Type.equals("Toxin")) {
						corrosiveDamageMods.add(electric.base / raw.base);
						corrosiveDamageMods.add(toxin.base / raw.base);
						electric.base = 0.0;
						toxin.base = 0.0;
					}
				} else if ((element1.equals("Fire") && element2.equals("Toxin")) || (element1.equals("Toxin") && element2.equals("Fire"))) {
					elements.add("Gas");
					gasDamageMods.add(globalFire + globalToxin);
					if (damageType.equals("Fire") || damageType.equals("Toxin") || damage2Type.equals("Fire") || damage2Type.equals("Toxin")) {
						gasDamageMods.add(fire.base / raw.base);
						gasDamageMods.add(toxin.base / raw.base);
						fire.base = 0.0;
						toxin.base = 0.0;
					}
				} else if ((element1.equals("Electric") && element2.equals("Ice")) || (element1.equals("Ice") && element2.equals("Electric"))) {
					elements.add("Magnetic");
					magneticDamageMods.add(globalElectric + globalIce);
					if (damageType.equals("Electric") || damageType.equals("Ice") || damage2Type.equals("Electric") || damage2Type.equals("Ice")) {
						magneticDamageMods.add(electric.base / raw.base);
						magneticDamageMods.add(ice.base / raw.base);
						electric.base = 0.0;
						ice.base = 0.0;
					}
				} else if ((element1.equals("Electric") && element2.equals("Fire")) || (element1.equals("Fire") && element2.equals("Electric"))) {
					elements.add("Radiation");
					radiationDamageMods.add(globalFire + globalElectric);
					if (damageType.equals("Fire") || damageType.equals("Electric") || damage2Type.equals("Fire") || damage2Type.equals("Electric")) {
						radiationDamageMods.add(fire.base / raw.base);
						radiationDamageMods.add(electric.base / raw.base);
						fire.base = 0.0;
						electric.base = 0.0;
					}
				} else if ((element1.equals("Ice") && element2.equals("Toxin")) || (element1.equals("Toxin") && element2.equals("Ice"))) {
					elements.add("Viral");
					viralDamageMods.add(globalToxin + globalIce);
					if (damageType.equals("Toxin") || damageType.equals("Ice") || damage2Type.equals("Toxin") || damage2Type.equals("Ice")) {
						viralDamageMods.add(toxin.base / raw.base);
						viralDamageMods.add(ice.base / raw.base);
						toxin.base = 0.0;
						ice.base = 0.0;
					}
				}
				elements.remove(i);
				elements.remove(i);
				i -= 1;
			}
		}

		// Mutalist Quanta: If hitscan, add electric damage
		if ((mQ1 > 0 || mQ2 > 0 || mQ3 > 0) && selectedWeapon.mQCombineElement.isSelected()) {

			globalElectric += mQ1;
			globalElectric += mQ2 * 3.65;
			globalElectric += mQ3 * 5;

			if (!elements.contains("Electric")) {
				elements.add("Electric");
			}
			if (!elements2.contains("Electric")) {
				elements2.add("Electric");
			}
		}

		// Uncombined elements
		if (elements.contains("Fire")) {
			fireDamageMods.add(globalFire);
		}
		if (elements.contains("Electric")) {
			electricDamageMods.add(globalElectric);
		}
		if (elements.contains("Toxin")) {
			toxinDamageMods.add(globalToxin);
		}
		if (elements.contains("Ice")) {
			iceDamageMods.add(globalIce);
		}

		// Mutalist Quanta note: Only projectile weapons cause explosions, so we know it
		// will combine (already added correctly from previous step).

		// Combine elements for the explosion
		for (int i = 0; i < elements2.size() - 1; i++) {
			String element1 = elements2.get(i);
			String element2 = elements2.get(i + 1);
			if ((element1.equals("Fire") || element1.equals("Ice") || element1.equals("Toxin") || element1.equals("Electric")) && (element2.equals("Fire") || element2.equals("Ice") || element2.equals("Toxin") || element2.equals("Electric"))) {

				if ((element1.equals("Fire") && element2.equals("Ice")) || (element1.equals("Ice") && element2.equals("Fire"))) {
					elements2.add("Blast");
					explosiveBlastDamageMods.add(globalFire + globalIce);
					if (explosiveDamage1Type.equals("Fire") || explosiveDamage1Type.equals("Ice") || explosiveDamage2Type.equals("Fire") || explosiveDamage2Type.equals("Ice")) {
						explosiveBlastDamageMods.add(explosiveFire.base / explosiveRaw.base);
						explosiveBlastDamageMods.add(explosiveIce.base / explosiveRaw.base);
						explosiveFire.base = 0.0;
						explosiveIce.base = 0.0;
					}
				} else if ((element1.equals("Electric") && element2.equals("Toxin")) || (element1.equals("Toxin") && element2.equals("Electric"))) {
					elements2.add("Corrosive");
					explosiveCorrosiveDamageMods.add(globalElectric + globalToxin);
					if (explosiveDamage1Type.equals("Electric") || explosiveDamage1Type.equals("Toxin") || explosiveDamage2Type.equals("Electric") || explosiveDamage2Type.equals("Toxin")) {
						explosiveCorrosiveDamageMods.add(explosiveElectric.base / explosiveRaw.base);
						explosiveCorrosiveDamageMods.add(explosiveToxin.base / explosiveRaw.base);
						explosiveElectric.base = 0.0;
						explosiveToxin.base = 0.0;
					}
				} else if ((element1.equals("Fire") && element2.equals("Toxin")) || (element1.equals("Toxin") && element2.equals("Fire"))) {
					elements2.add("Gas");
					explosiveGasDamageMods.add(globalFire + globalToxin);
					if (explosiveDamage1Type.equals("Fire") || explosiveDamage1Type.equals("Toxin") || explosiveDamage2Type.equals("Fire") || explosiveDamage2Type.equals("Toxin")) {
						explosiveGasDamageMods.add(explosiveFire.base / explosiveRaw.base);
						explosiveGasDamageMods.add(explosiveToxin.base / explosiveRaw.base);
						explosiveFire.base = 0.0;
						explosiveToxin.base = 0.0;
					}
				} else if ((element1.equals("Electric") && element2.equals("Ice")) || (element1.equals("Ice") && element2.equals("Electric"))) {
					elements2.add("Magnetic");
					explosiveMagneticDamageMods.add(globalElectric + globalIce);
					if (explosiveDamage1Type.equals("Electric") || explosiveDamage1Type.equals("Ice") || explosiveDamage2Type.equals("Electric") || explosiveDamage2Type.equals("Ice")) {
						explosiveMagneticDamageMods.add(explosiveElectric.base / explosiveRaw.base);
						explosiveMagneticDamageMods.add(explosiveIce.base / explosiveRaw.base);
						explosiveElectric.base = 0.0;
						explosiveIce.base = 0.0;
					}
				} else if ((element1.equals("Electric") && element2.equals("Fire")) || (element1.equals("Fire") && element2.equals("Electric"))) {
					elements2.add("Radiation");
					explosiveRadiationDamageMods.add(globalFire + globalElectric);
					if (explosiveDamage1Type.equals("Fire") || explosiveDamage1Type.equals("Electric") || explosiveDamage2Type.equals("Fire") || explosiveDamage2Type.equals("Electric")) {
						explosiveRadiationDamageMods.add(explosiveElectric.base / explosiveRaw.base);
						explosiveRadiationDamageMods.add(explosiveFire.base / explosiveRaw.base);
						explosiveFire.base = 0.0;
						explosiveElectric.base = 0.0;
					}
				} else if ((element1.equals("Ice") && element2.equals("Toxin")) || (element1.equals("Toxin") && element2.equals("Ice"))) {
					elements2.add("Viral");
					explosiveViralDamageMods.add(globalToxin + globalIce);
					if (explosiveDamage1Type.equals("Toxin") || explosiveDamage1Type.equals("Ice") || explosiveDamage2Type.equals("Toxin") || explosiveDamage2Type.equals("Ice")) {
						explosiveViralDamageMods.add(explosiveToxin.base / explosiveRaw.base);
						explosiveViralDamageMods.add(explosiveIce.base / explosiveRaw.base);
						explosiveToxin.base = 0.0;
						explosiveIce.base = 0.0;
					}
				}
				elements2.remove(i);
				elements2.remove(i);
				i -= 1;
			}
		}
		// Uncombined elements2 for the explosion
		if (elements2.contains("Fire")) {
			explosiveFireDamageMods.add(globalFire);
		}
		if (elements2.contains("Electric")) {
			explosiveElectricDamageMods.add(globalElectric);
		}
		if (elements2.contains("Toxin")) {
			explosiveToxinDamageMods.add(globalToxin);
		}
		if (elements2.contains("Ice")) {
			explosiveIceDamageMods.add(globalIce);
		}

		// Scope effects
		if (weaponMode.equals(Constants.LANKA) || weaponMode.equals(Constants.SNIPER)) {
			if (selectedWeapon.getScopeEffect() == Constants.ADDITIVE_CRIT_CHANCE) {
				addCritChanceMods.add(selectedWeapon.getScopeStrength());
			}
			if (selectedWeapon.getScopeEffect() == Constants.ADDITIVE_CRIT_DAMAGE) {
				critMultMods.add(selectedWeapon.getScopeStrength());
			}
			if (selectedWeapon.getScopeEffect() == Constants.HEADSHOT_BONUS) {
				headShotBonus += selectedWeapon.getScopeStrength();
			}
		}
		
		headShotBonus += selectedWeapon.getAddHS();

		// Mutalist Quanta: crit stuff
		if (mQ1 > 0 || mQ2 > 0 || mQ3 > 0) {
			addCritChanceMods.add(0.25 * (mQ1 + mQ2 + mQ3));
		}

		// Calculate finals
		double tempMag = mag;
		for (int i = 0; i < magMods.size(); i++) {
			tempMag += mag * magMods.get(i);
		}
		finalMag = (int) Math.round(tempMag);
		for (int i = 0; i < flatMagMods.size(); i++) {
			finalMag += flatMagMods.get(i);
		}
		finalMag = Math.max(1, finalMag);

		finalCritChance = critChance;
		for (int i = 0; i < critChanceMods.size(); i++) {
			finalCritChance += critChance * critChanceMods.get(i);
		}
		for (int i = 0; i < addCritChanceMods.size(); i++) {
			finalCritChance += addCritChanceMods.get(i);
		}
		finalCritChance += selectedWeapon.getAddCC();

		finalCritChance = Math.max(0, finalCritChance);

		finalCritMult = critMult;
		for (int i = 0; i < critMultMods.size(); i++) {
			finalCritMult += critMult * critMultMods.get(i);
		}
		finalCritMult += selectedWeapon.getAddCD();
		if (mQ1 > 0 || mQ2 > 0 || mQ3 > 0) { // Mutalist Quanta
			finalCritMult *= 1.25;
		}
		finalCritMult = Math.max(0, finalCritMult);

		finalFlatDamageBonus = flatDamageBonus;
		for (int i = 0; i < flatDamageMods.size(); i++) {
			finalFlatDamageBonus += flatDamageMods.get(i);
		}

		finalDeadAimMult = deadAimMult;
		for (int i = 0; i < deadAimMods.size(); i++) {
			finalDeadAimMult += deadAimMult * deadAimMods.get(i);
		}

		finalDamageMult = damageMult;
		for (int i = 0; i < damageMultMods.size(); i++) {
			finalDamageMult += damageMult * damageMultMods.get(i);
		}
		finalDamageMult += damageMult * selectedWeapon.getAddDam();

		finalDamageMult = Math.max(0, finalDamageMult);

		// Mutalist Quanta: damage stuff
		if (mQ1 > 0 || mQ2 > 0 || mQ3 > 0) {
			finalDamageMult *= Math.pow(0.66, mQ1 + mQ2 + mQ3);
		}

		startingCombo = Math.max(1, startingCombo);

		finalFireRate = fireRate;
		fireRateModPower = 0;
		for (int i = 0; i < fireRateMods.size(); i++) {
			fireRateModPower += fireRateMods.get(i);
		}
		if (weaponMode.equals(Constants.AUTOBOW) || weaponMode.equals(Constants.SEMIBOW) || weaponMode.equals(Constants.CHARGEBOW)) {
			fireRateModPower *= 2;
		}
		if (weaponMode.equals(Constants.CHARGE) || weaponMode.equals(Constants.LANKA) || weaponMode.equals(Constants.CHARGEBOW)) {
			double finalChargeTime = chargeTime / (1 + fireRateModPower + selectedWeapon.getAddFR());
			if (fireRate > 0) {
				finalFireRate = 1 / ((1 / (fireRate * (1 + fireRateModPower))) + finalChargeTime);
			} else {
				finalFireRate = 1 / finalChargeTime;
			}
		} else {
			finalFireRate += fireRate * fireRateModPower;
			finalFireRate += fireRate * selectedWeapon.getAddFR();
		}
		if (weaponMode.equals(Constants.SEMI_AUTO) || weaponMode.equals(Constants.SNIPER) || weaponMode.equals(Constants.SEMIBOW)) {
			if (finalFireRate > 10.0) {
				finalFireRate = 10.0;
			}
		}
		for (int i = 0; i < multiplicativeFireRateMods.size(); i++) { // Berserker only at this time
			finalFireRate *= (1 + multiplicativeFireRateMods.get(i));
		}
		finalFireRate = Math.max(0, finalFireRate);

		finalReloadTime = reloadTime;
		double reloadSpeedMult = 1.0;
		for (int i = 0; i < reloadTimeMods.size(); i++) {
			reloadSpeedMult += reloadTimeMods.get(i);
		}
		finalReloadTime /= reloadSpeedMult;

		finalProjectileCount = projectileCount;
		for (int i = 0; i < projectileCountMods.size(); i++) {
			finalProjectileCount += projectileCount * projectileCountMods.get(i);
		}
		finalProjectileCount = Math.max(0, finalProjectileCount);

		finalFirstShotDamageMult = firstShotDamageMult;
		for (int i = 0; i < firstShotDamageMods.size(); i++) {
			finalFirstShotDamageMult += firstShotDamageMult * firstShotDamageMods.get(i);
		}

		finalLastShotDamageMult = lastShotDamageMult;
		for (int i = 0; i < lastShotDamageMods.size(); i++) {
			finalLastShotDamageMult += lastShotDamageMult * lastShotDamageMods.get(i);
		}

		finalStatusChance = statusChance;
		for (int i = 0; i < statusChanceMods.size(); i++) {
			finalStatusChance += statusChance * statusChanceMods.get(i);
		}
		for (int i = 0; i < flatStatusMods.size(); i++) {
			double localStatus = flatStatusMods.get(i);
			finalStatusChance += localStatus;
		}
		finalStatusChance += selectedWeapon.getAddSC();
		averageStatusChance = finalStatusChance;

		finalStatusDuration = statusDuration;
		for (int i = 0; i < statusDurationMods.size(); i++) {
			finalStatusDuration += statusDuration * statusDurationMods.get(i);
		}
		finalStatusDuration = Math.max(0, finalStatusDuration);

		impact.finalBase = impact.base;
		explosiveImpact.finalBase = explosiveImpact.base;
		for (int i = 0; i < impactDamageMods.size(); i++) {
			impact.finalBase += impact.base * impactDamageMods.get(i);
			explosiveImpact.finalBase += explosiveImpact.base * impactDamageMods.get(i);
		}
		impact.finalBase = Math.max(0, impact.finalBase);
		explosiveImpact.finalBase = Math.max(0, explosiveImpact.finalBase);

		puncture.finalBase = puncture.base;
		explosivePuncture.finalBase = explosivePuncture.base;
		for (int i = 0; i < punctureDamageMods.size(); i++) {
			puncture.finalBase += puncture.base * punctureDamageMods.get(i);
			explosivePuncture.finalBase += explosivePuncture.base * punctureDamageMods.get(i);
		}
		puncture.finalBase = Math.max(0, puncture.finalBase);
		explosivePuncture.finalBase = Math.max(0, explosivePuncture.finalBase);

		slash.finalBase = slash.base;
		explosiveSlash.finalBase = explosiveSlash.base;
		for (int i = 0; i < slashDamageMods.size(); i++) {
			slash.finalBase += slash.base * slashDamageMods.get(i);
			explosiveSlash.finalBase += explosiveSlash.base * slashDamageMods.get(i);
		}
		slash.finalBase = Math.max(0, slash.finalBase);
		explosiveSlash.finalBase = Math.max(0, explosiveSlash.finalBase);

		fire.finalBase = fire.base;
		for (int i = 0; i < fireDamageMods.size(); i++) {
			fire.finalBase += raw.base * fireDamageMods.get(i);
		}
		explosiveFire.finalBase = explosiveFire.base;
		for (int i = 0; i < explosiveFireDamageMods.size(); i++) {
			explosiveFire.finalBase += explosiveRaw.base * explosiveFireDamageMods.get(i);
		}

		ice.finalBase = ice.base;
		for (int i = 0; i < iceDamageMods.size(); i++) {
			ice.finalBase += raw.base * iceDamageMods.get(i);
		}
		explosiveIce.finalBase = explosiveIce.base;
		for (int i = 0; i < explosiveIceDamageMods.size(); i++) {
			explosiveIce.finalBase += explosiveRaw.base * explosiveIceDamageMods.get(i);
		}

		electric.finalBase = electric.base;
		for (int i = 0; i < electricDamageMods.size(); i++) {
			electric.finalBase += raw.base * electricDamageMods.get(i);
		}
		explosiveElectric.finalBase = explosiveElectric.base;
		for (int i = 0; i < explosiveElectricDamageMods.size(); i++) {
			explosiveElectric.finalBase += explosiveRaw.base * explosiveElectricDamageMods.get(i);
		}

		toxin.finalBase = toxin.base;
		for (int i = 0; i < toxinDamageMods.size(); i++) {
			toxin.finalBase += raw.base * toxinDamageMods.get(i);
		}
		explosiveToxin.finalBase = explosiveToxin.base;
		for (int i = 0; i < explosiveToxinDamageMods.size(); i++) {
			explosiveToxin.finalBase += explosiveRaw.base * explosiveToxinDamageMods.get(i);
		}

		blast.finalBase = blast.base;
		for (int i = 0; i < blastDamageMods.size(); i++) {
			blast.finalBase += raw.base * blastDamageMods.get(i);
		}
		explosiveBlast.finalBase = explosiveBlast.base;
		for (int i = 0; i < explosiveBlastDamageMods.size(); i++) {
			explosiveBlast.finalBase += explosiveRaw.base * explosiveBlastDamageMods.get(i);
		}

		magnetic.finalBase = magnetic.base;
		for (int i = 0; i < magneticDamageMods.size(); i++) {
			magnetic.finalBase += raw.base * magneticDamageMods.get(i);
		}
		explosiveMagnetic.finalBase = explosiveMagnetic.base;
		for (int i = 0; i < explosiveMagneticDamageMods.size(); i++) {
			explosiveMagnetic.finalBase += explosiveRaw.base * explosiveMagneticDamageMods.get(i);
		}

		gas.finalBase = gas.base;
		for (int i = 0; i < gasDamageMods.size(); i++) {
			gas.finalBase += raw.base * gasDamageMods.get(i);
		}
		explosiveGas.finalBase = explosiveGas.base;
		for (int i = 0; i < explosiveGasDamageMods.size(); i++) {
			explosiveGas.finalBase += explosiveRaw.base * explosiveGasDamageMods.get(i);
		}

		radiation.finalBase = radiation.base;
		for (int i = 0; i < radiationDamageMods.size(); i++) {
			radiation.finalBase += raw.base * radiationDamageMods.get(i);
		}
		explosiveRadiation.finalBase = explosiveRadiation.base;
		for (int i = 0; i < explosiveRadiationDamageMods.size(); i++) {
			explosiveRadiation.finalBase += explosiveRaw.base * explosiveRadiationDamageMods.get(i);
		}

		corrosive.finalBase = corrosive.base;
		for (int i = 0; i < corrosiveDamageMods.size(); i++) {
			corrosive.finalBase += raw.base * corrosiveDamageMods.get(i);
		}
		explosiveCorrosive.finalBase = explosiveCorrosive.base;
		for (int i = 0; i < explosiveCorrosiveDamageMods.size(); i++) {
			explosiveCorrosive.finalBase += explosiveRaw.base * explosiveCorrosiveDamageMods.get(i);
		}

		viral.finalBase = viral.base;
		for (int i = 0; i < viralDamageMods.size(); i++) {
			viral.finalBase += raw.base * viralDamageMods.get(i);
		}
		explosiveViral.finalBase = explosiveViral.base;
		for (int i = 0; i < explosiveViralDamageMods.size(); i++) {
			explosiveViral.finalBase += explosiveRaw.base * explosiveViralDamageMods.get(i);
		}

		raw.finalBase = impact.finalBase + puncture.finalBase + slash.finalBase + fire.finalBase + ice.finalBase + electric.finalBase + toxin.finalBase + blast.finalBase + magnetic.finalBase + gas.finalBase + radiation.finalBase + corrosive.finalBase + viral.finalBase;
		explosiveRaw.finalBase = explosiveImpact.finalBase + explosivePuncture.finalBase + explosiveSlash.finalBase + explosiveFire.finalBase + explosiveIce.finalBase + explosiveElectric.finalBase + explosiveToxin.finalBase + explosiveBlast.finalBase + explosiveMagnetic.finalBase
				+ explosiveGas.finalBase + explosiveRadiation.finalBase + explosiveCorrosive.finalBase + explosiveViral.finalBase;

		finalCorpusMult = 1.0;
		for (int i = 0; i < corpusMods.size(); i++) {
			finalCorpusMult += corpusMods.get(i);
		}

		finalGrineerMult = 1.0;
		for (int i = 0; i < grineerMods.size(); i++) {
			finalGrineerMult += grineerMods.get(i);
		}

		finalCorruptedMult = 1.0;
		for (int i = 0; i < corruptedMods.size(); i++) {
			finalCorruptedMult += corruptedMods.get(i);
		}

		finalInfestedMult = 1.0;
		for (int i = 0; i < infestedMods.size(); i++) {
			finalInfestedMult += infestedMods.get(i);
		}

		if (headShots.isSelected()) {
			headShot = true;
		} else {
			headShot = false;
		}

		if (selectedWeapon.weaponType.equals(Constants.MELEE) && stanceCombo != null) { // Bunch of melee junk
			finalMag = stanceCombo.hits.size();

			finalProjectileCount = 1;

			double tempCombo = startingCombo;
			if (startingCombo < 2) {
				tempCombo = 0;
			}
			startingCombo = 1; // Melee no long multiplies damage by combo
			averageStatusChance += (tempCombo * comboStatus * statusChance);
			finalComboCrit = (tempCombo * comboCrit * critChance);

			avgHit = 0;
			avgDelay = 0;
			for (Hit h : stanceCombo.hits) {
				avgHit += (h.multiplier / stanceCombo.hits.size());
				avgDelay += (h.delay / stanceCombo.hits.size());
			}
		}

		if (weaponMode.equals(Constants.BURST)) {
			if (selectedWeapon.isRefireCanceled()) {
				finalFireRate += fireRate;
			}
			double burstDelay = 0.05;
			double burstMS = (1 / finalFireRate);
			double burstIterationMS = (burstMS * burstCount) + burstDelay;
			finalFireRate = (1 / burstIterationMS);
			if (finalFireRate > 10.0) {
				finalFireRate = 10.0;
			}
			double numBursts = finalMag / burstCount;
			double rawFireTime = numBursts / (finalFireRate / avgDelay);
			finalIterationTime = rawFireTime + finalReloadTime;
		} else if (weaponMode.equals(Constants.FULL_AUTO_RAMP_UP) || weaponMode.equals(Constants.FULL_AUTO_BULLET_RAMP)) {
			double baseFireDelay = ((1 / finalFireRate));
			double firstFireDelay = baseFireDelay * 5 / 2;
			double secondFireDelay = baseFireDelay * 5 / 3;
			double thirdFireDelay = baseFireDelay * 5 / 4;
			if (weaponMode.equals(Constants.FULL_AUTO_BULLET_RAMP)) { // Kohm's effective magazine size
				finalMag = (int) Math.round(projectileCount + (finalMag - (projectileCount / 3 - 1) - (projectileCount * (projectileCount + 1) / 2) / 3) / (projectileCount / 3));
			}
			finalIterationTime = (firstFireDelay + secondFireDelay + thirdFireDelay + ((finalMag - 4) * baseFireDelay)) + finalReloadTime;
		} else if (weaponMode.equals(Constants.CONTINUOUS)) {
			finalMag /= drain;
			finalIterationTime = ((finalMag) / finalFireRate) + finalReloadTime;
			averageStatusChance *= finalProjectileCount;
		} else if (weaponMode.equals(Constants.CHARGE) || weaponMode.equals(Constants.CHARGEBOW) || weaponMode.equals(Constants.LANKA)) {
			finalIterationTime = ((finalMag) / finalFireRate) + finalReloadTime;
		} else if (selectedWeapon.weaponType.equals(Constants.MELEE)) {
			finalIterationTime = ((finalMag) / (finalFireRate / avgDelay));
		} else {
			finalIterationTime = ((finalMag - 1) / (finalFireRate / avgDelay)) + finalReloadTime;
		}
		finalIterationsPerMinute = 60.0 / finalIterationTime;

		if (headShot) {
			headShotMult = 2;
		} else {
			headShotBonus = 1;
		}

		vigilante += selectedWeapon.vigiSlider.getValue();
		vigilante *= 0.05;

		averageCritMult = Math.max(0, 1 - (finalCritChance + finalComboCrit)) + headShotMult * ((finalCritChance + finalComboCrit) * finalCritMult - Math.max(0, (finalCritChance + finalComboCrit) - 1)) + (headShotMult * vigilante * (finalCritMult - 1));
	}

	/**
	 * Calculates miscellaneous values
	 */
	protected static void calculateMiscValues() {
		
		// Status Ratios
		double totalprocWeight = raw.finalBase;
		slashProcRate = slash.finalBase / raw.finalBase;
		fireProcRate = fire.finalBase / raw.finalBase;
		toxinProcRate = toxin.finalBase / raw.finalBase;
		gasProcRate = gas.finalBase / raw.finalBase;
		electricProcRate = electric.finalBase / raw.finalBase;
		impactProcRate = impact.finalBase / raw.finalBase;
		punctureProcRate = puncture.finalBase / raw.finalBase;
		iceProcRate = ice.finalBase / raw.finalBase;
		corrosiveProcRate = corrosive.finalBase / raw.finalBase;
		viralProcRate = viral.finalBase / raw.finalBase;
		blastProcRate = blast.finalBase / raw.finalBase;
		radiationProcRate = radiation.finalBase / raw.finalBase;
		magneticProcRate = magnetic.finalBase / raw.finalBase;

		if (explosiveRaw.finalBase != 0) {
			explosiveSlashProcRate = explosiveSlash.finalBase / explosiveRaw.finalBase;
			explosiveFireProcRate = explosiveFire.finalBase / explosiveRaw.finalBase;
			explosiveToxinProcRate = explosiveToxin.finalBase / explosiveRaw.finalBase;
			explosiveGasProcRate = explosiveGas.finalBase / explosiveRaw.finalBase;
			explosiveElectricProcRate = explosiveElectric.finalBase / explosiveRaw.finalBase;
			explosiveImpactProcRate = explosiveImpact.finalBase / explosiveRaw.finalBase;
			explosivePunctureProcRate = explosivePuncture.finalBase / explosiveRaw.finalBase;
			explosiveIceProcRate = explosiveIce.finalBase / explosiveRaw.finalBase;
			explosiveCorrosiveProcRate = explosiveCorrosive.finalBase / explosiveRaw.finalBase;
			explosiveViralProcRate = explosiveViral.finalBase / explosiveRaw.finalBase;
			explosiveBlastProcRate = explosiveBlast.finalBase / explosiveRaw.finalBase;
			explosiveRadiationProcRate = explosiveRadiation.finalBase / explosiveRaw.finalBase;
			explosiveMagneticProcRate = explosiveMagnetic.finalBase / explosiveRaw.finalBase;
		}

		forcedSlashProcs = 0;
		forcedImpactProcs = 0;
		forcedPunctureProcs = 0;
		forcedKnockdownProcs = 0;
		if (selectedWeapon.weaponType.equals(Constants.MELEE) && stanceCombo != null) {
			for (Hit h : stanceCombo.hits) {
				if (h.procs[0].equals("1")) {
					forcedSlashProcs += 1;
				}
				if (h.procs[8].equals("1")) {
					forcedImpactProcs += 1;
				}
				if (h.procs[9].equals("1")) {
					forcedPunctureProcs += 1;
				}
				if (h.procs[12].equals("1")) {
					forcedKnockdownProcs += 1;
				}
			}
			forcedSlashProcs /= stanceCombo.hits.size();
			forcedImpactProcs /= stanceCombo.hits.size();
			forcedPunctureProcs /= stanceCombo.hits.size();
			forcedKnockdownProcs /= stanceCombo.hits.size();
		}

		// Condition overload
		if (conditionOverload > 0) {
			COMult += replaceNaN(1 - Math.pow((1 - slashProcRate * averageStatusChance) * (1 - forcedSlashProcs), (finalFireRate / avgDelay) * 6 * finalStatusDuration));
			COMult += replaceNaN(1 - Math.pow((1 - fireProcRate * averageStatusChance), (finalFireRate / avgDelay) * 6 * finalStatusDuration));
			COMult += replaceNaN(1 - Math.pow((1 - toxinProcRate * averageStatusChance), (finalFireRate / avgDelay) * 6 * finalStatusDuration));
			COMult += replaceNaN(1 - Math.pow((1 - gasProcRate * averageStatusChance), (finalFireRate / avgDelay) * 6 * finalStatusDuration));
			COMult += replaceNaN(1 - Math.pow((1 - electricProcRate * averageStatusChance), (finalFireRate / avgDelay) * 6 * finalStatusDuration));
			COMult += replaceNaN(1 - Math.pow((1 - impactProcRate * averageStatusChance) * (1 - forcedImpactProcs), (finalFireRate / avgDelay) * 6 * finalStatusDuration));
			COMult += replaceNaN(1 - Math.pow((1 - punctureProcRate * averageStatusChance) * (1 - forcedPunctureProcs), (finalFireRate / avgDelay) * 6 * finalStatusDuration));
			COMult += replaceNaN(1 - Math.pow((1 - iceProcRate * averageStatusChance), (finalFireRate / avgDelay) * 6 * finalStatusDuration));
			COMult += replaceNaN(1 - Math.pow((1 - corrosiveProcRate * averageStatusChance), (finalFireRate / avgDelay) * 8 * finalStatusDuration));
			COMult += replaceNaN(1 - Math.pow((1 - viralProcRate * averageStatusChance), (finalFireRate / avgDelay) * 6 * finalStatusDuration));
			COMult += replaceNaN(1 - Math.pow((1 - blastProcRate * averageStatusChance), (finalFireRate / avgDelay) * 6 * finalStatusDuration));
			COMult += replaceNaN(1 - Math.pow((1 - blastProcRate * averageStatusChance) * (1 - forcedKnockdownProcs), (finalFireRate / avgDelay) * 6 * finalStatusDuration)); // Knockdown
			COMult += replaceNaN(1 - Math.pow((1 - radiationProcRate * averageStatusChance), (finalFireRate / avgDelay) * 12 * finalStatusDuration));
			COMult += replaceNaN(1 - Math.pow((1 - magneticProcRate * averageStatusChance), (finalFireRate / avgDelay) * 6 * finalStatusDuration));
			COMult *= conditionOverload;
		}
		// adjust COMult for base damage mods
		COMult = (COMult + finalDamageMult) / (finalDamageMult);

		averageProjectileCount = finalProjectileCount;
		if (weaponMode.equals(Constants.FULL_AUTO_BULLET_RAMP)) { // kohm's average projectile count and status chance
			averageProjectileCount = finalProjectileCount * ((((projectileCount * (projectileCount + 1) / 2) + projectileCount * (finalMag - projectileCount)) / finalMag) / projectileCount);

			averageStatusChance = ((1 - Math.pow((1 - finalStatusChance / 3), 1 / projectileCount)) * 3) * (finalMag - projectileCount) / finalMag;
			for (double i = 1; i <= projectileCount; i++) {
				double tempstatus = (1 - Math.pow((1 - finalStatusChance / 3), (1 / i))) * 3;
				averageStatusChance += tempstatus / finalMag;
			}
		}
		
		if (weaponMode.equals(Constants.CONTINUOUS)) {
			procsPerSecond = (finalMag * averageStatusChance) * (1 / finalIterationTime);
			burstProcsPerSecond = averageStatusChance * (finalFireRate / avgDelay);
		} else {
			procsPerSecond = ((averageProjectileCount * finalMag) * averageStatusChance) * (1 / finalIterationTime);
			burstProcsPerSecond = averageProjectileCount * averageStatusChance * (finalFireRate / avgDelay);
		}
		
		
		double potentialProcs = ((averageProjectileCount * finalMag) * (1 / finalIterationTime)) * (6 * finalStatusDuration);
		double potentialBurstProcs = (averageProjectileCount * (finalFireRate / avgDelay)) * (6 * finalStatusDuration);
		
		// viral multiplier
		if (viralProcRate > 0) {
			viralMult = 1;
			int procCountTotal = (int) (procsPerSecond * 6 * finalStatusDuration);
			double totalChance = binomial(procCountTotal, 0).doubleValue() * Math.pow(viralProcRate, 0) * Math.pow(1 - viralProcRate, procCountTotal - 0);
			for (int i = 1; i < Math.min(10,procCountTotal); i++) {
				double chance = binomial(procCountTotal, i).doubleValue() * Math.pow(viralProcRate, i) * Math.pow(1 - viralProcRate, procCountTotal - i);
				double mult = 1 + (i-1) * 0.25;
				totalChance += chance;
				viralMult += chance * mult;
			}
			if(procCountTotal > 10)
				viralMult += (1 - totalChance) * 3.25;
		}

		// non-stacking fire stacks
		if (DPSPanel.fireProcLabel.isSelected()) {
			fireStacks = procsPerSecond * fireProcRate * 6;
			burstFireStacks = burstProcsPerSecond * fireProcRate * 6;
			explosiveFireStacks = procsPerSecond * explosiveFireProcRate * (6 * finalStatusDuration);
			explosiveBurstFireStacks = burstProcsPerSecond * explosiveFireProcRate * (6 * finalStatusDuration);
		} else if (fireProcRate > 0) {
			fireStacks = 1 / Math.pow((1 - fireProcRate * averageStatusChance), potentialProcs);
			burstFireStacks = 1 / Math.pow((1 - fireProcRate * averageStatusChance), potentialBurstProcs);
			explosiveFireStacks = 1 / Math.pow((1 - explosiveFireProcRate * averageStatusChance), potentialProcs);
			explosiveBurstFireStacks = 1 / Math.pow((1 - explosiveFireProcRate * averageStatusChance), potentialBurstProcs);
		}
		
		slashStacks = ((slashProcRate * averageStatusChance) + (hunterMunitions * Math.min(1, (finalCritChance + finalComboCrit))) + forcedSlashProcs) * potentialProcs;
		burstSlashStacks = ((slashProcRate * averageStatusChance) + (hunterMunitions * Math.min(1, (finalCritChance + finalComboCrit))) + forcedSlashProcs) * potentialBurstProcs;
		explosiveSlashStacks = ((explosiveSlashProcRate * averageStatusChance) + (hunterMunitions * Math.min(1, (finalCritChance + finalComboCrit))) + forcedSlashProcs) * potentialProcs;
		explosiveBurstSlashStacks = ((explosiveSlashProcRate * averageStatusChance) + (hunterMunitions * Math.min(1, (finalCritChance + finalComboCrit))) + forcedSlashProcs) * potentialBurstProcs;

		toxinStacks = procsPerSecond * toxinProcRate * (6 * finalStatusDuration);
		burstToxinStacks = burstProcsPerSecond * toxinProcRate * (6 * finalStatusDuration);
		explosiveToxinStacks = procsPerSecond * explosiveToxinProcRate * (6 * finalStatusDuration);
		explosiveBurstToxinStacks = burstProcsPerSecond * explosiveToxinProcRate * (6 * finalStatusDuration);
		
		gasStacks = procsPerSecond * gasProcRate * (6 * finalStatusDuration);
		burstGasStacks = burstProcsPerSecond * gasProcRate * (6 * finalStatusDuration);
		explosiveGasStacks = procsPerSecond * explosiveGasProcRate * (6 * finalStatusDuration);
		explosiveBurstGasStacks = burstProcsPerSecond * explosiveGasProcRate * (6 * finalStatusDuration);

		electricStacks = procsPerSecond * electricProcRate * (6 * finalStatusDuration);
		burstElectricStacks = burstProcsPerSecond * electricProcRate * (6 * finalStatusDuration);
		explosiveElectricStacks = procsPerSecond * explosiveElectricProcRate * (6 * finalStatusDuration);
		explosiveBurstElectricStacks = burstProcsPerSecond * explosiveElectricProcRate * (6 * finalStatusDuration);
		
		switch (forcedProc) {
		case Constants.FIRE_WEAPON_DAMAGE:
			fireStacks += potentialProcs;
			burstFireStacks += potentialBurstProcs;
			break;
		case Constants.ELECTRIC_WEAPON_DAMAGE:
			electricStacks += potentialProcs;
			burstElectricStacks += potentialBurstProcs;
			break;
		case Constants.TOXIN_WEAPON_DAMAGE:
			toxinStacks += potentialProcs;
			burstToxinStacks += potentialBurstProcs;
			break;
		case Constants.GAS_WEAPON_DAMAGE:
			gasStacks += potentialProcs;
			burstGasStacks += potentialBurstProcs;
			break;
		}	

		// Final Damage values
		impact.finalBase *= finalDamageMult;
		explosiveImpact.finalBase *= finalDamageMult;

		puncture.finalBase *= finalDamageMult;
		explosivePuncture.finalBase *= finalDamageMult;

		slash.finalBase *= finalDamageMult;
		explosiveSlash.finalBase *= finalDamageMult;

		fire.finalBase *= finalDamageMult;
		explosiveFire.finalBase *= finalDamageMult;

		ice.finalBase *= finalDamageMult;
		explosiveIce.finalBase *= finalDamageMult;

		electric.finalBase *= finalDamageMult;
		explosiveElectric.finalBase *= finalDamageMult;

		toxin.finalBase *= finalDamageMult;
		explosiveToxin.finalBase *= finalDamageMult;

		blast.finalBase *= finalDamageMult;
		explosiveBlast.finalBase *= finalDamageMult;

		magnetic.finalBase *= finalDamageMult;
		explosiveMagnetic.finalBase *= finalDamageMult;

		gas.finalBase *= finalDamageMult;
		explosiveGas.finalBase *= finalDamageMult;

		radiation.finalBase *= finalDamageMult;
		explosiveRadiation.finalBase *= finalDamageMult;

		corrosive.finalBase *= finalDamageMult;
		explosiveCorrosive.finalBase *= finalDamageMult;

		viral.finalBase *= finalDamageMult;
		explosiveViral.finalBase *= finalDamageMult;

		raw.finalBase = impact.finalBase + puncture.finalBase + slash.finalBase + fire.finalBase + ice.finalBase + electric.finalBase + toxin.finalBase + blast.finalBase + magnetic.finalBase + gas.finalBase + radiation.finalBase + corrosive.finalBase + viral.finalBase;
		explosiveRaw.finalBase = explosiveImpact.finalBase + explosivePuncture.finalBase + explosiveSlash.finalBase + explosiveFire.finalBase + explosiveIce.finalBase + explosiveElectric.finalBase + explosiveToxin.finalBase + explosiveBlast.finalBase + explosiveMagnetic.finalBase
				+ explosiveGas.finalBase + explosiveRadiation.finalBase + explosiveCorrosive.finalBase + explosiveViral.finalBase;

	}

	/**
	 * Calculates the damage per shot values
	 */
	protected static void calculateDamagePerShot() {

		// Calculate base damage per shot values
		raw.perShot = (raw.finalBase + explosiveRaw.finalBase) * averageProjectileCount * finalDeadAimMult * COMult * startingCombo * headShotMult * headShotBonus * avgHit * viralMult;

		// Calculate crit damage per shot values
		raw.critPerShot = raw.perShot * finalCritMult * headShotMult * headShotBonus;

		finalFirstShotDamageMult -= 1;
		// Calculate first-shot damage
		raw.firstShot = raw.perShot * averageCritMult * finalFirstShotDamageMult;

		finalLastShotDamageMult -= 1;
		// Calculate last-shot damage
		raw.lastShot = raw.perShot * averageCritMult * finalLastShotDamageMult;

		// factions
		corpus.perShot = raw.perShot * finalCorpusMult;
		grineer.perShot = raw.perShot * finalGrineerMult;
		infested.perShot = raw.perShot * finalInfestedMult;
		corrupted.perShot = raw.perShot * finalCorruptedMult;

		corpus.firstShot = corpus.perShot * averageCritMult * finalFirstShotDamageMult;
		grineer.firstShot = grineer.perShot * averageCritMult * finalFirstShotDamageMult;
		infested.firstShot = infested.perShot * averageCritMult * finalFirstShotDamageMult;
		corrupted.firstShot = corrupted.perShot * averageCritMult * finalFirstShotDamageMult;

		corpus.lastShot = corpus.perShot * averageCritMult * finalLastShotDamageMult;
		grineer.lastShot = grineer.perShot * averageCritMult * finalLastShotDamageMult;
		infested.lastShot = infested.perShot * averageCritMult * finalLastShotDamageMult;
		corrupted.lastShot = corrupted.perShot * averageCritMult * finalLastShotDamageMult;

		if (updateOutput) {

			corpus.critPerShot = corpus.perShot * finalCritMult;
			grineer.critPerShot = grineer.perShot * finalCritMult;
			infested.critPerShot = infested.perShot * finalCritMult;
			corrupted.critPerShot = corrupted.perShot * finalCritMult;

			// Calculate base damage per shot values
			impact.perShot = impact.finalBase * averageProjectileCount * finalDeadAimMult * COMult * headShotMult * headShotBonus * viralMult;
			puncture.perShot = puncture.finalBase * averageProjectileCount * finalDeadAimMult * COMult * headShotMult * headShotBonus * viralMult;
			slash.perShot = slash.finalBase * averageProjectileCount * finalDeadAimMult * COMult * headShotMult * headShotBonus * viralMult;
			fire.perShot = fire.finalBase * averageProjectileCount * finalDeadAimMult * COMult * headShotMult * headShotBonus * viralMult;
			ice.perShot = ice.finalBase * averageProjectileCount * finalDeadAimMult * COMult * headShotMult * headShotBonus * viralMult;
			electric.perShot = electric.finalBase * averageProjectileCount * finalDeadAimMult * COMult * headShotMult * headShotBonus * viralMult;
			toxin.perShot = toxin.finalBase * averageProjectileCount * finalDeadAimMult * COMult * headShotMult * headShotBonus * viralMult;
			blast.perShot = blast.finalBase * averageProjectileCount * finalDeadAimMult * COMult * headShotMult * headShotBonus * viralMult;
			magnetic.perShot = magnetic.finalBase * averageProjectileCount * finalDeadAimMult * COMult * headShotMult * headShotBonus * viralMult;
			gas.perShot = gas.finalBase * averageProjectileCount * finalDeadAimMult * COMult * headShotMult * headShotBonus * viralMult;
			radiation.perShot = radiation.finalBase * averageProjectileCount * finalDeadAimMult * COMult * headShotMult * headShotBonus * viralMult;
			corrosive.perShot = corrosive.finalBase * averageProjectileCount * finalDeadAimMult * COMult * headShotMult * headShotBonus * viralMult;
			viral.perShot = viral.finalBase * averageProjectileCount * finalDeadAimMult * COMult * headShotMult * headShotBonus * viralMult;

			// Surface-specific

			cloneFlesh.perShot += impact.perShot * 0.75;
			cloneFlesh.perShot += puncture.perShot;
			cloneFlesh.perShot += slash.perShot * 1.25;
			cloneFlesh.perShot += fire.perShot * 1.25;
			cloneFlesh.perShot += ice.perShot;
			cloneFlesh.perShot += electric.perShot;
			cloneFlesh.perShot += toxin.perShot;
			cloneFlesh.perShot += blast.perShot;
			cloneFlesh.perShot += magnetic.perShot;
			cloneFlesh.perShot += gas.perShot * 0.5;
			cloneFlesh.perShot += radiation.perShot;
			cloneFlesh.perShot += corrosive.perShot;
			cloneFlesh.perShot += viral.perShot * 1.75;
			cloneFlesh.perShot *= finalGrineerMult;

			ferrite.perShot += impact.perShot;
			ferrite.perShot += puncture.perShot * 1.5;
			ferrite.perShot += slash.perShot * 0.85;
			ferrite.perShot += fire.perShot;
			ferrite.perShot += ice.perShot;
			ferrite.perShot += electric.perShot;
			ferrite.perShot += toxin.perShot;
			ferrite.perShot += blast.perShot * 0.75;
			ferrite.perShot += magnetic.perShot;
			ferrite.perShot += gas.perShot;
			ferrite.perShot += radiation.perShot;
			ferrite.perShot += corrosive.perShot * 1.75;
			ferrite.perShot += viral.perShot;

			alloy.perShot += impact.perShot;
			alloy.perShot += puncture.perShot * 1.15;
			alloy.perShot += slash.perShot * 0.5;
			alloy.perShot += fire.perShot;
			alloy.perShot += ice.perShot * 1.25;
			alloy.perShot += electric.perShot * 0.5;
			alloy.perShot += toxin.perShot;
			alloy.perShot += blast.perShot;
			alloy.perShot += magnetic.perShot * 0.5;
			alloy.perShot += gas.perShot;
			alloy.perShot += radiation.perShot * 1.75;
			alloy.perShot += corrosive.perShot;
			alloy.perShot += viral.perShot;

			mechanical.perShot += impact.perShot * 1.25;
			mechanical.perShot += puncture.perShot;
			mechanical.perShot += slash.perShot;
			mechanical.perShot += fire.perShot;
			mechanical.perShot += ice.perShot;
			mechanical.perShot += electric.perShot * 1.5;
			mechanical.perShot += toxin.perShot * 0.75;
			mechanical.perShot += blast.perShot * 1.75;
			mechanical.perShot += magnetic.perShot;
			mechanical.perShot += gas.perShot;
			mechanical.perShot += radiation.perShot;
			mechanical.perShot += corrosive.perShot;
			mechanical.perShot += viral.perShot * 0.75;
			mechanical.perShot *= finalGrineerMult;

			corpusFlesh.perShot += impact.perShot * 0.75;
			corpusFlesh.perShot += puncture.perShot;
			corpusFlesh.perShot += slash.perShot * 1.25;
			corpusFlesh.perShot += fire.perShot;
			corpusFlesh.perShot += ice.perShot;
			corpusFlesh.perShot += electric.perShot;
			corpusFlesh.perShot += toxin.perShot * 1.5;
			corpusFlesh.perShot += blast.perShot;
			corpusFlesh.perShot += magnetic.perShot;
			corpusFlesh.perShot += gas.perShot * 0.75;
			corpusFlesh.perShot += radiation.perShot;
			corpusFlesh.perShot += corrosive.perShot;
			corpusFlesh.perShot += viral.perShot * 1.5;
			corpusFlesh.perShot *= finalCorpusMult;

			shield.perShot += impact.perShot * 1.5;
			shield.perShot += puncture.perShot * 0.85;
			shield.perShot += slash.perShot;
			shield.perShot += fire.perShot;
			shield.perShot += ice.perShot * 1.5;
			shield.perShot += electric.perShot;
			shield.perShot += toxin.perShot;
			shield.perShot += blast.perShot;
			shield.perShot += magnetic.perShot * 1.75;
			shield.perShot += gas.perShot;
			shield.perShot += radiation.perShot * 0.75;
			shield.perShot += corrosive.perShot;
			shield.perShot += viral.perShot;
			shield.perShot *= finalCorpusMult;

			protoShield.perShot += impact.perShot * 1.15;
			protoShield.perShot += puncture.perShot * 0.5;
			protoShield.perShot += slash.perShot;
			protoShield.perShot += fire.perShot * 0.5;
			protoShield.perShot += ice.perShot;
			protoShield.perShot += electric.perShot;
			protoShield.perShot += toxin.perShot * 1.25;
			protoShield.perShot += blast.perShot;
			protoShield.perShot += magnetic.perShot * 1.75;
			protoShield.perShot += gas.perShot;
			protoShield.perShot += radiation.perShot;
			protoShield.perShot += corrosive.perShot * 0.5;
			protoShield.perShot += viral.perShot;
			protoShield.perShot *= finalCorpusMult;

			robotic.perShot += impact.perShot;
			robotic.perShot += puncture.perShot * 1.25;
			robotic.perShot += slash.perShot * 0.75;
			robotic.perShot += fire.perShot;
			robotic.perShot += ice.perShot;
			robotic.perShot += electric.perShot * 1.5;
			robotic.perShot += toxin.perShot * 0.75;
			robotic.perShot += blast.perShot;
			robotic.perShot += magnetic.perShot;
			robotic.perShot += gas.perShot;
			robotic.perShot += radiation.perShot * 1.25;
			robotic.perShot += corrosive.perShot;
			robotic.perShot += viral.perShot;
			robotic.perShot *= finalCorpusMult;

			infestedFlesh.perShot += impact.perShot;
			infestedFlesh.perShot += puncture.perShot;
			infestedFlesh.perShot += slash.perShot * 1.5;
			infestedFlesh.perShot += fire.perShot * 1.5;
			infestedFlesh.perShot += ice.perShot * 0.5;
			infestedFlesh.perShot += electric.perShot;
			infestedFlesh.perShot += toxin.perShot;
			infestedFlesh.perShot += blast.perShot;
			infestedFlesh.perShot += magnetic.perShot;
			infestedFlesh.perShot += gas.perShot * 1.5;
			infestedFlesh.perShot += radiation.perShot;
			infestedFlesh.perShot += corrosive.perShot;
			infestedFlesh.perShot += viral.perShot;
			infestedFlesh.perShot *= finalInfestedMult;

			fossilized.perShot += impact.perShot;
			fossilized.perShot += puncture.perShot;
			fossilized.perShot += slash.perShot * 1.15;
			fossilized.perShot += fire.perShot;
			fossilized.perShot += ice.perShot * 0.75;
			fossilized.perShot += electric.perShot;
			fossilized.perShot += toxin.perShot * 0.5;
			fossilized.perShot += blast.perShot * 1.5;
			fossilized.perShot += magnetic.perShot;
			fossilized.perShot += gas.perShot;
			fossilized.perShot += radiation.perShot * 0.25;
			fossilized.perShot += corrosive.perShot * 1.75;
			fossilized.perShot += viral.perShot;
			fossilized.perShot *= finalInfestedMult;

			sinew.perShot += impact.perShot;
			sinew.perShot += puncture.perShot * 1.25;
			sinew.perShot += slash.perShot;
			sinew.perShot += fire.perShot;
			sinew.perShot += ice.perShot * 1.25;
			sinew.perShot += electric.perShot;
			sinew.perShot += toxin.perShot;
			sinew.perShot += blast.perShot * 0.5;
			sinew.perShot += magnetic.perShot;
			sinew.perShot += gas.perShot;
			sinew.perShot += radiation.perShot * 1.5;
			sinew.perShot += corrosive.perShot;
			sinew.perShot += viral.perShot;
			sinew.perShot *= finalInfestedMult;

			// Calculate crit damage per shot values
			impact.critPerShot = impact.perShot * finalCritMult;
			puncture.critPerShot = puncture.perShot * finalCritMult;
			slash.critPerShot = slash.perShot * finalCritMult;
			fire.critPerShot = fire.perShot * finalCritMult;
			ice.critPerShot = ice.perShot * finalCritMult;
			electric.critPerShot = electric.perShot * finalCritMult;
			toxin.critPerShot = toxin.perShot * finalCritMult;
			blast.critPerShot = blast.perShot * finalCritMult;
			magnetic.critPerShot = magnetic.perShot * finalCritMult;
			gas.critPerShot = gas.perShot * finalCritMult;
			radiation.critPerShot = radiation.perShot * finalCritMult;
			corrosive.critPerShot = corrosive.perShot * finalCritMult;
			viral.critPerShot = viral.perShot * finalCritMult;
			cloneFlesh.critPerShot = cloneFlesh.perShot * finalCritMult;
			ferrite.critPerShot = ferrite.perShot * finalCritMult;
			alloy.critPerShot = alloy.perShot * finalCritMult;
			mechanical.critPerShot = mechanical.perShot * finalCritMult;
			corpusFlesh.critPerShot = corpusFlesh.perShot * finalCritMult;
			shield.critPerShot = shield.perShot * finalCritMult;
			protoShield.critPerShot = protoShield.perShot * finalCritMult;
			robotic.critPerShot = robotic.perShot * finalCritMult;
			infestedFlesh.critPerShot = infestedFlesh.perShot * finalCritMult;
			fossilized.critPerShot = fossilized.perShot * finalCritMult;
			sinew.critPerShot = sinew.perShot * finalCritMult;

			// Calculate surface first-shot damage
			impact.firstShot = impact.perShot * averageCritMult * finalFirstShotDamageMult;
			puncture.firstShot = puncture.perShot * averageCritMult * finalFirstShotDamageMult;
			slash.firstShot = slash.perShot * averageCritMult * finalFirstShotDamageMult;
			fire.firstShot = fire.perShot * averageCritMult * finalFirstShotDamageMult;
			ice.firstShot = ice.perShot * averageCritMult * finalFirstShotDamageMult;
			electric.firstShot = electric.perShot * averageCritMult * finalFirstShotDamageMult;
			toxin.firstShot = toxin.perShot * averageCritMult * finalFirstShotDamageMult;
			blast.firstShot = blast.perShot * averageCritMult * finalFirstShotDamageMult;
			magnetic.firstShot = magnetic.perShot * averageCritMult * finalFirstShotDamageMult;
			gas.firstShot = gas.perShot * averageCritMult * finalFirstShotDamageMult;
			radiation.firstShot = radiation.perShot * averageCritMult * finalFirstShotDamageMult;
			corrosive.firstShot = corrosive.perShot * averageCritMult * finalFirstShotDamageMult;
			viral.firstShot = viral.perShot * averageCritMult * finalFirstShotDamageMult;
			cloneFlesh.firstShot = cloneFlesh.perShot * averageCritMult * finalFirstShotDamageMult;
			ferrite.firstShot = ferrite.perShot * averageCritMult * finalFirstShotDamageMult;
			alloy.firstShot = alloy.perShot * averageCritMult * finalFirstShotDamageMult;
			mechanical.firstShot = mechanical.perShot * averageCritMult * finalFirstShotDamageMult;
			corpusFlesh.firstShot = corpusFlesh.perShot * averageCritMult * finalFirstShotDamageMult;
			shield.firstShot = shield.perShot * averageCritMult * finalFirstShotDamageMult;
			protoShield.firstShot = protoShield.perShot * averageCritMult * finalFirstShotDamageMult;
			robotic.firstShot = robotic.perShot * averageCritMult * finalFirstShotDamageMult;
			infestedFlesh.firstShot = infestedFlesh.perShot * averageCritMult * finalFirstShotDamageMult;
			fossilized.firstShot = fossilized.perShot * averageCritMult * finalFirstShotDamageMult;
			sinew.firstShot = sinew.perShot * averageCritMult * finalFirstShotDamageMult;

			// Calculate surface last-shot damage
			impact.lastShot = impact.perShot * averageCritMult * finalLastShotDamageMult;
			puncture.lastShot = puncture.perShot * averageCritMult * finalLastShotDamageMult;
			slash.lastShot = slash.perShot * averageCritMult * finalLastShotDamageMult;
			fire.lastShot = fire.perShot * averageCritMult * finalLastShotDamageMult;
			ice.lastShot = ice.perShot * averageCritMult * finalLastShotDamageMult;
			electric.lastShot = electric.perShot * averageCritMult * finalLastShotDamageMult;
			toxin.lastShot = toxin.perShot * averageCritMult * finalLastShotDamageMult;
			blast.lastShot = blast.perShot * averageCritMult * finalLastShotDamageMult;
			magnetic.lastShot = magnetic.perShot * averageCritMult * finalLastShotDamageMult;
			gas.lastShot = gas.perShot * averageCritMult * finalLastShotDamageMult;
			radiation.lastShot = radiation.perShot * averageCritMult * finalLastShotDamageMult;
			corrosive.lastShot = corrosive.perShot * averageCritMult * finalLastShotDamageMult;
			viral.lastShot = viral.perShot * averageCritMult * finalLastShotDamageMult;
			cloneFlesh.lastShot = cloneFlesh.perShot * averageCritMult * finalLastShotDamageMult;
			ferrite.lastShot = ferrite.perShot * averageCritMult * finalLastShotDamageMult;
			alloy.lastShot = alloy.perShot * averageCritMult * finalLastShotDamageMult;
			mechanical.lastShot = mechanical.perShot * averageCritMult * finalLastShotDamageMult;
			corpusFlesh.lastShot = corpusFlesh.perShot * averageCritMult * finalLastShotDamageMult;
			shield.lastShot = shield.perShot * averageCritMult * finalLastShotDamageMult;
			protoShield.lastShot = protoShield.perShot * averageCritMult * finalLastShotDamageMult;
			robotic.lastShot = robotic.perShot * averageCritMult * finalLastShotDamageMult;
			infestedFlesh.lastShot = infestedFlesh.perShot * averageCritMult * finalLastShotDamageMult;
			fossilized.lastShot = fossilized.perShot * averageCritMult * finalLastShotDamageMult;
			sinew.lastShot = sinew.perShot * averageCritMult * finalLastShotDamageMult;
		}
	}

	/**
	 * Calculates the total damage done over an entire magazine
	 */
	protected static void calculateDamagePerIteration() {
		raw.perIteration = raw.perShot * finalMag * averageCritMult + raw.firstShot + raw.lastShot;

		corpus.perIteration = corpus.perShot * finalMag * averageCritMult + corpus.firstShot + corpus.lastShot;
		grineer.perIteration = grineer.perShot * finalMag * averageCritMult + grineer.firstShot + grineer.lastShot;
		infested.perIteration = infested.perShot * finalMag * averageCritMult + infested.firstShot + infested.lastShot;
		corrupted.perIteration = corrupted.perShot * finalMag * averageCritMult + corrupted.firstShot + corrupted.lastShot;

		if (updateOutput) {
			impact.perIteration = impact.perShot * finalMag * averageCritMult + impact.firstShot + impact.lastShot;
			puncture.perIteration = puncture.perShot * finalMag * averageCritMult + puncture.firstShot + puncture.lastShot;
			slash.perIteration = slash.perShot * finalMag * averageCritMult + slash.firstShot + slash.lastShot;
			fire.perIteration = fire.perShot * finalMag * averageCritMult + fire.firstShot + fire.lastShot;
			ice.perIteration = ice.perShot * finalMag * averageCritMult + ice.firstShot + ice.lastShot;
			electric.perIteration = electric.perShot * finalMag * averageCritMult + electric.firstShot + electric.lastShot;
			toxin.perIteration = toxin.perShot * finalMag * averageCritMult + toxin.firstShot + toxin.lastShot;
			blast.perIteration = blast.perShot * finalMag * averageCritMult + blast.firstShot + blast.lastShot;
			magnetic.perIteration = magnetic.perShot * finalMag * averageCritMult + magnetic.firstShot + magnetic.lastShot;
			gas.perIteration = gas.perShot * finalMag * averageCritMult + gas.firstShot + gas.lastShot;
			radiation.perIteration = radiation.perShot * finalMag * averageCritMult + radiation.firstShot + radiation.lastShot;
			corrosive.perIteration = corrosive.perShot * finalMag * averageCritMult + corrosive.firstShot + corrosive.lastShot;
			viral.perIteration = viral.perShot * finalMag * averageCritMult + viral.firstShot + viral.lastShot;
			cloneFlesh.perIteration = cloneFlesh.perShot * finalMag * averageCritMult + cloneFlesh.firstShot + cloneFlesh.lastShot;
			ferrite.perIteration = ferrite.perShot * finalMag * averageCritMult + ferrite.firstShot + ferrite.lastShot;
			alloy.perIteration = alloy.perShot * finalMag * averageCritMult + alloy.firstShot + alloy.lastShot;
			mechanical.perIteration = mechanical.perShot * finalMag * averageCritMult + mechanical.firstShot + mechanical.lastShot;
			corpusFlesh.perIteration = corpusFlesh.perShot * finalMag * averageCritMult + corpusFlesh.firstShot + corpusFlesh.lastShot;
			shield.perIteration = shield.perShot * finalMag * averageCritMult + shield.firstShot + shield.lastShot;
			protoShield.perIteration = protoShield.perShot * finalMag * averageCritMult + protoShield.firstShot + protoShield.lastShot;
			robotic.perIteration = robotic.perShot * finalMag * averageCritMult + robotic.firstShot + robotic.lastShot;
			infestedFlesh.perIteration = infestedFlesh.perShot * finalMag * averageCritMult + infestedFlesh.firstShot + infestedFlesh.lastShot;
			fossilized.perIteration = fossilized.perShot * finalMag * averageCritMult + fossilized.firstShot + fossilized.lastShot;
			sinew.perIteration = sinew.perShot * finalMag * averageCritMult + sinew.firstShot + sinew.lastShot;
		}
	}

	/**
	 * Calculates the total damage dealt over a given minute.
	 */
	protected static void calculateDamagePerMinute() {
		raw.perMinute = raw.perIteration * finalIterationsPerMinute;

		corpus.perMinute = corpus.perIteration * finalIterationsPerMinute;
		grineer.perMinute = grineer.perIteration * finalIterationsPerMinute;
		infested.perMinute = infested.perIteration * finalIterationsPerMinute;
		corrupted.perMinute = corrupted.perIteration * finalIterationsPerMinute;

		if (updateOutput) {
			impact.perMinute = impact.perIteration * finalIterationsPerMinute;
			puncture.perMinute = puncture.perIteration * finalIterationsPerMinute;
			slash.perMinute = slash.perIteration * finalIterationsPerMinute;
			fire.perMinute = fire.perIteration * finalIterationsPerMinute;
			ice.perMinute = ice.perIteration * finalIterationsPerMinute;
			electric.perMinute = electric.perIteration * finalIterationsPerMinute;
			toxin.perMinute = toxin.perIteration * finalIterationsPerMinute;
			blast.perMinute = blast.perIteration * finalIterationsPerMinute;
			magnetic.perMinute = magnetic.perIteration * finalIterationsPerMinute;
			gas.perMinute = gas.perIteration * finalIterationsPerMinute;
			radiation.perMinute = radiation.perIteration * finalIterationsPerMinute;
			corrosive.perMinute = corrosive.perIteration * finalIterationsPerMinute;
			viral.perMinute = viral.perIteration * finalIterationsPerMinute;
			cloneFlesh.perMinute = cloneFlesh.perIteration * finalIterationsPerMinute;
			ferrite.perMinute = ferrite.perIteration * finalIterationsPerMinute;
			alloy.perMinute = alloy.perIteration * finalIterationsPerMinute;
			mechanical.perMinute = mechanical.perIteration * finalIterationsPerMinute;
			corpus.perMinute = corpusFlesh.perIteration * finalIterationsPerMinute;
			shield.perMinute = shield.perIteration * finalIterationsPerMinute;
			protoShield.perMinute = protoShield.perIteration * finalIterationsPerMinute;
			robotic.perMinute = robotic.perIteration * finalIterationsPerMinute;
			infestedFlesh.perMinute = infestedFlesh.perIteration * finalIterationsPerMinute;
			fossilized.perMinute = fossilized.perIteration * finalIterationsPerMinute;
			sinew.perMinute = sinew.perIteration * finalIterationsPerMinute;
		}
	}

	protected static void calculateDamagePerSecond() {
		// Calculate base DPS values
		raw.perSecond = raw.perMinute / 60.0;

		corpus.perSecond = corpus.perMinute / 60.0;
		grineer.perSecond = grineer.perMinute / 60.0;
		infested.perSecond = infested.perMinute / 60.0;
		corrupted.perSecond = corrupted.perMinute / 60.0;

		// Add in DoTs
		double hunterMult = 1;
		if (hunterMunitions > 0) { // Need to fix because hunter munitions stacks are always on crit
			double hunterRatio = (Math.min(1, finalCritChance + finalComboCrit) * hunterMunitions) / (1 - ((1 - (slashProcRate * averageStatusChance)) * (1 - (hunterMunitions * Math.min(1, finalCritChance + finalComboCrit)))));
			hunterMult = (hunterRatio * finalCritMult * headShotMult * headShotBonus + (1 - hunterRatio) * averageCritMult) / averageCritMult;
		}
		double stanceSlashMult = 1;
		if (selectedWeapon.weaponType.equals(Constants.MELEE) && stanceCombo != null) {
			stanceSlashMult = 0;
			double stanceSlashes = 0;
			for (Hit h : stanceCombo.hits) {
				if (h.procs[0].equals("1")) {
					stanceSlashMult += h.multiplier;
					stanceSlashes += 1;
				}
			}
			stanceSlashMult /= stanceSlashes;
			double stanceRatio = (stanceSlashes / stanceCombo.hits.size()) / (1 - ((1 - (slashProcRate * averageStatusChance)) * (1 - stanceSlashes / stanceCombo.hits.size())));
			stanceSlashMult = (stanceRatio * stanceSlashMult + (1 - stanceRatio)) / avgHit;
		}
		if (Double.isNaN(stanceSlashMult)) {
			stanceSlashMult = 1;
		}

		double DoTBase = raw.base * finalDamageMult * COMult * viralMult * finalDeadAimMult * startingCombo * avgHit * (1 + (finalFirstShotDamageMult + finalLastShotDamageMult) / finalMag) * headShotMult * headShotBonus * averageCritMult;
		double electricBase = DoTBase * (1 + globalElectric) * 0.5 * headShotMult * headShotBonus;
		double bleedDamage = (DoTBase * 0.35 * hunterMult) * stanceSlashMult;
		double poisonDamage = (DoTBase * (1 + globalToxin)) * 0.5;
		double heatDamage = (DoTBase * (1 + globalFire)) * 0.5;
		double cloudDamage = DoTBase * 0.5;

		double explosiveDoTBase = explosiveRaw.base * finalDamageMult * COMult * viralMult * finalDeadAimMult * startingCombo * avgHit * (1 + (finalFirstShotDamageMult + finalLastShotDamageMult) / finalMag) * headShotMult * headShotBonus * averageCritMult;
		double explosiveElectricBase = explosiveDoTBase * (1 + globalElectric) * 0.5 * headShotMult * headShotBonus;
		double explosiveBleedDamage = (explosiveDoTBase * 0.35 * hunterMult) * stanceSlashMult;
		double explosivePoisonDamage = (explosiveDoTBase * (1 + globalToxin)) * 0.5;
		double explosiveHeatDamage = (explosiveDoTBase * (1 + globalFire)) * 0.5;
		double explosiveCloudDamage = explosiveDoTBase * 0.5;

		bleedDoTDPS = slashStacks * bleedDamage;
		bleedDoTDPS += explosiveSlashStacks * explosiveBleedDamage;
		burstBleedDoTDPS = burstSlashStacks * bleedDamage;
		burstBleedDoTDPS += explosiveBurstSlashStacks * explosiveBleedDamage;

		poisonDoTDPS = toxinStacks * poisonDamage;
		poisonDoTDPS += explosiveToxinStacks * explosivePoisonDamage;
		burstPoisonDoTDPS = burstToxinStacks * poisonDamage;
		burstPoisonDoTDPS += explosiveBurstToxinStacks * explosivePoisonDamage;

		heatDoTDPS = fireStacks * heatDamage;
		heatDoTDPS += explosiveFireStacks * explosiveHeatDamage;
		burstHeatDoTDPS = burstFireStacks * heatDamage;
		burstHeatDoTDPS += explosiveBurstFireStacks * explosiveHeatDamage;

		cloudDoTDPS = gasStacks * cloudDamage;
		cloudDoTDPS += explosiveGasStacks * explosiveCloudDamage;
		burstCloudDoTDPS = burstGasStacks * cloudDamage;
		burstCloudDoTDPS += explosiveBurstGasStacks * explosiveCloudDamage;

		electricProcDPS = electricStacks * electricBase;
		electricProcDPS += explosiveElectricStacks * explosiveElectricBase;
		burstElectricProcDPS = burstElectricStacks * electricBase;
		burstElectricProcDPS += explosiveBurstElectricStacks * explosiveElectricBase;

		raw.perSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);

		corpus.perSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS) * finalCorpusMult * finalCorpusMult;
		grineer.perSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS) * finalGrineerMult * finalGrineerMult;
		infested.perSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS) * finalInfestedMult * finalInfestedMult;
		corrupted.perSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS) * finalCorruptedMult * finalCorruptedMult;

		if (updateOutput) {
			impact.perSecond = impact.perMinute / 60.0;
			puncture.perSecond = puncture.perMinute / 60.0;
			slash.perSecond = slash.perMinute / 60.0;
			fire.perSecond = fire.perMinute / 60.0;
			ice.perSecond = ice.perMinute / 60.0;
			electric.perSecond = electric.perMinute / 60.0;
			toxin.perSecond = toxin.perMinute / 60.0;
			blast.perSecond = blast.perMinute / 60.0;
			magnetic.perSecond = magnetic.perMinute / 60.0;
			gas.perSecond = gas.perMinute / 60.0;
			radiation.perSecond = radiation.perMinute / 60.0;
			corrosive.perSecond = corrosive.perMinute / 60.0;
			viral.perSecond = viral.perMinute / 60.0;
			cloneFlesh.perSecond = cloneFlesh.perMinute / 60.0;
			ferrite.perSecond = ferrite.perMinute / 60.0;
			alloy.perSecond = alloy.perMinute / 60.0;
			mechanical.perSecond = mechanical.perMinute / 60.0;
			corpusFlesh.perSecond = corpusFlesh.perMinute / 60.0;
			shield.perSecond = shield.perMinute / 60.0;
			protoShield.perSecond = protoShield.perMinute / 60.0;
			robotic.perSecond = robotic.perMinute / 60.0;
			infestedFlesh.perSecond = infestedFlesh.perMinute / 60.0;
			fossilized.perSecond = fossilized.perMinute / 60.0;
			sinew.perSecond = sinew.perMinute / 60.0;
			cloneFlesh.perSecond += (bleedDoTDPS + poisonDoTDPS + (heatDoTDPS * 1.25) + cloudDoTDPS * finalGrineerMult);
			ferrite.perSecond += (bleedDoTDPS + (poisonDoTDPS) + heatDoTDPS + (cloudDoTDPS));
			alloy.perSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS);
			mechanical.perSecond += (bleedDoTDPS + (poisonDoTDPS * 0.75) + heatDoTDPS + (cloudDoTDPS * 0.75 * finalGrineerMult));
			corpusFlesh.perSecond += (bleedDoTDPS + (poisonDoTDPS * 1.5) + heatDoTDPS + (cloudDoTDPS * 1.5 * finalCorpusMult));
			shield.perSecond += (heatDoTDPS);
			protoShield.perSecond += ((heatDoTDPS * 0.5));
			robotic.perSecond += (bleedDoTDPS + (poisonDoTDPS * 0.75) + heatDoTDPS + (cloudDoTDPS * 0.75 * finalCorpusMult));
			infestedFlesh.perSecond += (bleedDoTDPS + poisonDoTDPS + (heatDoTDPS * 1.5) + cloudDoTDPS * finalInfestedMult);
			fossilized.perSecond += (bleedDoTDPS + (poisonDoTDPS * 0.5) + heatDoTDPS + (cloudDoTDPS * finalInfestedMult * 0.5));
			sinew.perSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS * finalInfestedMult);
		}
	}

	protected static void calculateBurstDamagePerSecond() {
		// Calculate base Burst DPS values
		double burstTime = (1 / (finalIterationTime - finalReloadTime));
		raw.rawPerSecond = raw.perIteration * burstTime;

		// Add in DoTs
		raw.rawPerSecond += (burstBleedDoTDPS + burstPoisonDoTDPS + burstHeatDoTDPS + burstElectricProcDPS + burstCloudDoTDPS);

		corpus.rawPerSecond = corpus.perIteration * burstTime;
		grineer.rawPerSecond = grineer.perIteration * burstTime;
		infested.rawPerSecond = infested.perIteration * burstTime;
		corrupted.rawPerSecond = corrupted.perIteration * burstTime;

		corpus.rawPerSecond += (burstBleedDoTDPS + burstPoisonDoTDPS + burstHeatDoTDPS + burstElectricProcDPS + burstCloudDoTDPS) * finalCorpusMult * finalCorpusMult;
		grineer.rawPerSecond += (burstBleedDoTDPS + burstPoisonDoTDPS + burstHeatDoTDPS + burstElectricProcDPS + burstCloudDoTDPS) * finalGrineerMult * finalGrineerMult;
		infested.rawPerSecond += (burstBleedDoTDPS + burstPoisonDoTDPS + burstHeatDoTDPS + burstElectricProcDPS + burstCloudDoTDPS) * finalInfestedMult * finalInfestedMult;
		corrupted.rawPerSecond += (burstBleedDoTDPS + burstPoisonDoTDPS + burstHeatDoTDPS + burstElectricProcDPS + burstCloudDoTDPS) * finalCorruptedMult * finalCorruptedMult;

		if (updateOutput) {
			impact.rawPerSecond = impact.perIteration * burstTime;
			puncture.rawPerSecond = puncture.perIteration * burstTime;
			slash.rawPerSecond = slash.perIteration * burstTime;
			fire.rawPerSecond = fire.perIteration * burstTime;
			ice.rawPerSecond = ice.perIteration * burstTime;
			electric.rawPerSecond = electric.perIteration * burstTime;
			toxin.rawPerSecond = toxin.perIteration * burstTime;
			blast.rawPerSecond = blast.perIteration * burstTime;
			magnetic.rawPerSecond = magnetic.perIteration * burstTime;
			gas.rawPerSecond = gas.perIteration * burstTime;
			radiation.rawPerSecond = radiation.perIteration * burstTime;
			corrosive.rawPerSecond = corrosive.perIteration * burstTime;
			viral.rawPerSecond = viral.perIteration * burstTime;
			cloneFlesh.rawPerSecond = cloneFlesh.perIteration * burstTime;
			ferrite.rawPerSecond = ferrite.perIteration * burstTime;
			alloy.rawPerSecond = alloy.perIteration * burstTime;
			mechanical.rawPerSecond = mechanical.perIteration * burstTime;
			corpusFlesh.rawPerSecond = corpusFlesh.perIteration * burstTime;
			shield.rawPerSecond = shield.perIteration * burstTime;
			protoShield.rawPerSecond = protoShield.perIteration * burstTime;
			robotic.rawPerSecond = robotic.perIteration * burstTime;
			infestedFlesh.rawPerSecond = infestedFlesh.perIteration * burstTime;
			fossilized.rawPerSecond = fossilized.perIteration * burstTime;
			sinew.rawPerSecond = sinew.perIteration * burstTime;

			cloneFlesh.rawPerSecond += (burstBleedDoTDPS + burstPoisonDoTDPS + (burstHeatDoTDPS * 1.25) + burstCloudDoTDPS * finalGrineerMult);
			ferrite.rawPerSecond += (burstBleedDoTDPS + (burstPoisonDoTDPS) + burstHeatDoTDPS + (burstCloudDoTDPS));
			alloy.rawPerSecond += (burstBleedDoTDPS + burstPoisonDoTDPS + burstHeatDoTDPS + burstCloudDoTDPS);
			mechanical.rawPerSecond += (burstBleedDoTDPS + (burstPoisonDoTDPS * 0.75) + burstHeatDoTDPS + (burstCloudDoTDPS * 0.75 * finalGrineerMult));
			corpusFlesh.rawPerSecond += (burstBleedDoTDPS + (burstPoisonDoTDPS * 1.5) + burstHeatDoTDPS + (burstCloudDoTDPS * 1.5 * finalCorpusMult));
			shield.rawPerSecond += burstHeatDoTDPS;
			protoShield.rawPerSecond += burstHeatDoTDPS * 0.5;
			robotic.rawPerSecond += (burstBleedDoTDPS + (burstPoisonDoTDPS * 0.75) + burstHeatDoTDPS + (burstCloudDoTDPS * 0.75 * finalCorpusMult));
			infestedFlesh.rawPerSecond += (burstBleedDoTDPS + burstPoisonDoTDPS + (burstHeatDoTDPS * 1.5) + burstCloudDoTDPS * finalInfestedMult);
			fossilized.rawPerSecond += (burstBleedDoTDPS + (burstPoisonDoTDPS * 0.5) + burstHeatDoTDPS + (burstCloudDoTDPS * finalInfestedMult * 0.5));
			sinew.rawPerSecond += (burstBleedDoTDPS + burstPoisonDoTDPS + burstHeatDoTDPS + burstCloudDoTDPS * finalInfestedMult);
		}
	}

	/**
	 * Appends the weapon information to the output text area
	 */
	protected static void updateOutput() {
		// Append to Output
		DecimalFormat f = new DecimalFormat("#.###");
		output.append("\n");
		output.append("\n_____________________________________________________________");
		output.append("\nName :: " + weaponName);
		output.append("\nMagazine Size :: " + finalMag);
		output.append("\nTotal Ammo :: " + (finalMag + finalAmmo));
		output.append("\nCrit Chance :: " + f.format((finalCritChance + finalComboCrit) * 100.0) + "%");
		output.append("\nCrit Damage Multiplier :: " + f.format(finalCritMult * 100.0) + "%");
		String delimiter = "rounds";
		String mode = selectedWeapon.getWeaponMode();
		if (mode.equals(Constants.BURST)) {
			delimiter = "bursts";
		} else if (mode.equals(Constants.CONTINUOUS)) {
			delimiter = "ticks";
		}
		output.append("\nFire Rate :: " + f.format(finalFireRate / avgDelay) + " " + delimiter + " per second");
		output.append("\nReload Time :: " + f.format(finalReloadTime) + " seconds");
		output.append("\nStatus Chance :: " + f.format(averageStatusChance * 100.0) + "%");
		output.append("\nAverage Projectiles Per Shot :: " + f.format(averageProjectileCount));
		output.append("\nStatus Procs Per Second :: " + f.format(procsPerSecond));
		output.append("\nBurst Status Procs Per Second :: " + f.format(burstProcsPerSecond));
		output.append("\nTime to Empty magazine :: " + f.format(finalIterationTime - finalReloadTime) + " seconds");
		if (slashStacks > 0) {
			output.append("\nAverage Bleed Stacks :: " + slashStacks);
		}
		if (toxinStacks > 0) {
			output.append("\nAverage Poison Stacks :: " + toxinStacks);
		}
		if (gasStacks > 0) {
			output.append("\nAverage Poison Cloud Stacks :: " + gasStacks);
		}
		if (fireStacks > 0) {
			output.append("\nAverage Burning Stacks :: " + fireStacks);
		}
		output.append("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		output.append("\nRaw Damage Per Shot :: " + f.format(raw.perShot));
		if (impact.perShot > 0.0) {
			output.append("\nImpact Damage Per Shot :: " + f.format(impact.perShot));
		}
		if (puncture.perShot > 0.0) {
			output.append("\nPuncture Damage Per Shot :: " + f.format(puncture.perShot));
		}
		if (slash.perShot > 0.0) {
			output.append("\nSlash Damage Per Shot :: " + f.format(slash.perShot));
		}
		if (fire.perShot > 0.0) {
			output.append("\nFire Damage Per Shot :: " + f.format(fire.perShot));
		}
		if (ice.perShot > 0.0) {
			output.append("\nIce Damage Per Shot :: " + f.format(ice.perShot));
		}
		if (electric.perShot > 0.0) {
			output.append("\nElectric Damage Per Shot :: " + f.format(electric.perShot));
		}
		if (toxin.perShot > 0.0) {
			output.append("\nToxin Damage Per Shot :: " + f.format(toxin.perShot));
		}
		if (blast.perShot > 0.0) {
			output.append("\nBlast Damage Per Shot :: " + f.format(blast.perShot));
		}
		if (magnetic.perShot > 0.0) {
			output.append("\nMagnetic Damage Per Shot :: " + f.format(magnetic.perShot));
		}
		if (gas.perShot > 0.0) {
			output.append("\nGas Damage Per Shot :: " + f.format(gas.perShot));
		}
		if (radiation.perShot > 0.0) {
			output.append("\nRadiation Damage Per Shot :: " + f.format(radiation.perShot));
		}
		if (corrosive.perShot > 0.0) {
			output.append("\nCorrosive Damage Per Shot :: " + f.format(corrosive.perShot));
		}
		if (viral.perShot > 0.0) {
			output.append("\nViral Damage Per Shot :: " + f.format(viral.perShot));
		}
		output.append("\nDamage Per Shot to Clone Flesh :: " + f.format(cloneFlesh.perShot));
		output.append("\nDamage Per Shot to Ferrite Armor :: " + f.format(ferrite.perShot));
		output.append("\nDamage Per Shot to Alloy Armor :: " + f.format(alloy.perShot));
		output.append("\nDamage Per Shot to Mechanical :: " + f.format(mechanical.perShot));
		output.append("\nDamage Per Shot to Corpus Flesh :: " + f.format(corpusFlesh.perShot));
		output.append("\nDamage Per Shot to Shield :: " + f.format(shield.perShot));
		output.append("\nDamage Per Shot to Proto Shield :: " + f.format(protoShield.perShot));
		output.append("\nDamage Per Shot to Robotic :: " + f.format(robotic.perShot));
		output.append("\nDamage Per Shot to Infested Flesh :: " + f.format(infestedFlesh.perShot));
		output.append("\nDamage Per Shot to Fossilized :: " + f.format(fossilized.perShot));
		output.append("\nDamage Per Shot to Sinew :: " + f.format(sinew.perShot));
		output.append("\nDamage Per Shot to Corpus :: " + f.format(corpus.perShot));
		output.append("\nDamage Per Shot to Grineer :: " + f.format(grineer.perShot));
		output.append("\nDamage Per Shot to Infested :: " + f.format(infested.perShot));
		output.append("\nDamage Per Shot to Corrupted :: " + f.format(corrupted.perShot));
		output.append("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		output.append("\nRaw Crit Damage Per Shot :: " + f.format(raw.critPerShot));
		if (impact.critPerShot > 0.0) {
			output.append("\nImpact Crit Damage Per Shot :: " + f.format(impact.critPerShot));
		}
		if (puncture.critPerShot > 0.0) {
			output.append("\nPuncture Crit Damage Per Shot :: " + f.format(puncture.critPerShot));
		}
		if (slash.critPerShot > 0.0) {
			output.append("\nSlash Crit Damage Per Shot :: " + f.format(slash.critPerShot));
		}
		if (fire.critPerShot > 0.0) {
			output.append("\nFire Crit Damage Per Shot :: " + f.format(fire.critPerShot));
		}
		if (ice.critPerShot > 0.0) {
			output.append("\nIce Crit Damage Per Shot :: " + f.format(ice.critPerShot));
		}
		if (electric.critPerShot > 0.0) {
			output.append("\nElectric Crit Damage Per Shot :: " + f.format(electric.critPerShot));
		}
		if (toxin.critPerShot > 0.0) {
			output.append("\nToxin Crit Damage Per Shot :: " + f.format(toxin.critPerShot));
		}
		if (blast.critPerShot > 0.0) {
			output.append("\nBlast Crit Damage Per Shot :: " + f.format(blast.critPerShot));
		}
		if (magnetic.critPerShot > 0.0) {
			output.append("\nMagnetic Crit Damage Per Shot :: " + f.format(magnetic.critPerShot));
		}
		if (gas.critPerShot > 0.0) {
			output.append("\nGas Crit Damage Per Shot :: " + f.format(gas.critPerShot));
		}
		if (radiation.critPerShot > 0.0) {
			output.append("\nRadiation Crit Damage Per Shot :: " + f.format(radiation.critPerShot));
		}
		if (corrosive.critPerShot > 0.0) {
			output.append("\nCorrosive Crit Damage Per Shot :: " + f.format(corrosive.critPerShot));
		}
		if (viral.critPerShot > 0.0) {
			output.append("\nViral Crit Damage Per Shot :: " + f.format(viral.critPerShot));
		}
		output.append("\nCrit Damage Per Shot to Clone Flesh :: " + f.format(cloneFlesh.critPerShot));
		output.append("\nCrit Damage Per Shot to Ferrite Armor :: " + f.format(ferrite.critPerShot));
		output.append("\nCrit Damage Per Shot to Alloy Armor :: " + f.format(alloy.critPerShot));
		output.append("\nCrit Damage Per Shot to Mechanical :: " + f.format(mechanical.critPerShot));
		output.append("\nCrit Damage Per Shot to Corpus Flesh :: " + f.format(corpusFlesh.critPerShot));
		output.append("\nCrit Damage Per Shot to Shield :: " + f.format(shield.critPerShot));
		output.append("\nCrit Damage Per Shot to Proto Shield :: " + f.format(protoShield.critPerShot));
		output.append("\nCrit Damage Per Shot to Robotic :: " + f.format(robotic.critPerShot));
		output.append("\nCrit Damage Per Shot to Infested Flesh :: " + f.format(infestedFlesh.critPerShot));
		output.append("\nCrit Damage Per Shot to Fossilized :: " + f.format(fossilized.critPerShot));
		output.append("\nCrit Damage Per Shot to Sinew :: " + f.format(sinew.critPerShot));
		output.append("\nCrit Damage Per Shot to Corpus :: " + f.format(corpus.critPerShot));
		output.append("\nCrit Damage Per Shot to Grineer :: " + f.format(grineer.critPerShot));
		output.append("\nCrit Damage Per Shot to Infested :: " + f.format(infested.critPerShot));
		output.append("\nCrit Damage Per Shot to Corrupted :: " + f.format(corrupted.critPerShot));
		if (finalFirstShotDamageMult > 0) {
			output.append("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			output.append("\nRaw First Shot Damage :: " + f.format(raw.firstShot * (1 + finalFirstShotDamageMult) / finalFirstShotDamageMult));
			if (impact.firstShot > 0.0) {
				output.append("\nImpact First Shot Damage :: " + f.format(impact.firstShot * (1 + finalFirstShotDamageMult) / finalFirstShotDamageMult));
			}
			if (puncture.firstShot > 0.0) {
				output.append("\nPuncture First Shot Damage :: " + f.format(puncture.firstShot * (1 + finalFirstShotDamageMult) / finalFirstShotDamageMult));
			}
			if (slash.firstShot > 0.0) {
				output.append("\nSlash First Shot Damage :: " + f.format(slash.firstShot * (1 + finalFirstShotDamageMult) / finalFirstShotDamageMult));
			}
			if (fire.firstShot > 0.0) {
				output.append("\nFire First Shot Damage :: " + f.format(fire.firstShot * (1 + finalFirstShotDamageMult) / finalFirstShotDamageMult));
			}
			if (ice.firstShot > 0.0) {
				output.append("\nIce First Shot Damage :: " + f.format(ice.firstShot * (1 + finalFirstShotDamageMult) / finalFirstShotDamageMult));
			}
			if (electric.firstShot > 0.0) {
				output.append("\nElectric First Shot Damage :: " + f.format(electric.firstShot * (1 + finalFirstShotDamageMult) / finalFirstShotDamageMult));
			}
			if (toxin.firstShot > 0.0) {
				output.append("\nToxin First Shot Damage :: " + f.format(toxin.firstShot * (1 + finalFirstShotDamageMult) / finalFirstShotDamageMult));
			}
			if (blast.firstShot > 0.0) {
				output.append("\nBlast First Shot Damage :: " + f.format(blast.firstShot * (1 + finalFirstShotDamageMult) / finalFirstShotDamageMult));
			}
			if (magnetic.firstShot > 0.0) {
				output.append("\nMagnetic First Shot Damage :: " + f.format(magnetic.firstShot * (1 + finalFirstShotDamageMult) / finalFirstShotDamageMult));
			}
			if (gas.firstShot > 0.0) {
				output.append("\nGas First Shot Damage :: " + f.format(gas.firstShot * (1 + finalFirstShotDamageMult) / finalFirstShotDamageMult));
			}
			if (radiation.firstShot > 0.0) {
				output.append("\nRadiation First Shot Damage :: " + f.format(radiation.firstShot * (1 + finalFirstShotDamageMult) / finalFirstShotDamageMult));
			}
			if (corrosive.firstShot > 0.0) {
				output.append("\nCorrosive First Shot Damage :: " + f.format(corrosive.firstShot * (1 + finalFirstShotDamageMult) / finalFirstShotDamageMult));
			}
			if (viral.firstShot > 0.0) {
				output.append("\nViral First Shot Damage :: " + f.format(viral.firstShot * (1 + finalFirstShotDamageMult) / finalFirstShotDamageMult));
			}
			output.append("\nFirst Shot Damage to Clone Flesh :: " + f.format(cloneFlesh.firstShot));
			output.append("\nFirst Shot Damage to Ferrite Armor :: " + f.format(ferrite.firstShot));
			output.append("\nFirst Shot Damage to Alloy Armor :: " + f.format(alloy.firstShot));
			output.append("\nFirst Shot Damage to Mechanical :: " + f.format(mechanical.firstShot));
			output.append("\nFirst Shot Damage to Corpus Flesh :: " + f.format(corpusFlesh.firstShot));
			output.append("\nFirst Shot Damage to Shield :: " + f.format(shield.firstShot));
			output.append("\nFirst Shot Damage to Proto Shield :: " + f.format(protoShield.firstShot));
			output.append("\nFirst Shot Damage to Robotic :: " + f.format(robotic.firstShot));
			output.append("\nFirst Shot Damage to Infested Flesh :: " + f.format(infestedFlesh.firstShot));
			output.append("\nFirst Shot Damage to Fossilized :: " + f.format(fossilized.firstShot));
			output.append("\nFirst Shot Damage to Sinew :: " + f.format(sinew.firstShot));
			output.append("\nFirst Shot Damage to Corpus :: " + f.format(corpus.firstShot));
			output.append("\nFirst Shot Damage to Grineer :: " + f.format(grineer.firstShot));
			output.append("\nFirst Shot Damage to Infested :: " + f.format(infested.firstShot));
			output.append("\nFirst Shot Damage to Corrupted :: " + f.format(corrupted.firstShot));
		}
		if (finalLastShotDamageMult > 0) {
			output.append("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			output.append("\nRaw Last Shot Damage :: " + f.format(raw.lastShot * (1 + finalLastShotDamageMult) / finalLastShotDamageMult));
			if (impact.lastShot > 0.0) {
				output.append("\nImpact Last Shot Damage :: " + f.format(impact.lastShot * (1 + finalLastShotDamageMult) / finalLastShotDamageMult));
			}
			if (puncture.lastShot > 0.0) {
				output.append("\nPuncture Last Shot Damage :: " + f.format(puncture.lastShot * (1 + finalLastShotDamageMult) / finalLastShotDamageMult));
			}
			if (slash.lastShot > 0.0) {
				output.append("\nSlash Last Shot Damage :: " + f.format(slash.lastShot * (1 + finalLastShotDamageMult) / finalLastShotDamageMult));
			}
			if (fire.lastShot > 0.0) {
				output.append("\nFire Last Shot Damage :: " + f.format(fire.lastShot * (1 + finalLastShotDamageMult) / finalLastShotDamageMult));
			}
			if (ice.lastShot > 0.0) {
				output.append("\nIce Last Shot Damage :: " + f.format(ice.lastShot * (1 + finalLastShotDamageMult) / finalLastShotDamageMult));
			}
			if (electric.lastShot > 0.0) {
				output.append("\nElectric Last Shot Damage :: " + f.format(electric.lastShot * (1 + finalLastShotDamageMult) / finalLastShotDamageMult));
			}
			if (toxin.lastShot > 0.0) {
				output.append("\nToxin Last Shot Damage :: " + f.format(toxin.lastShot * (1 + finalLastShotDamageMult) / finalLastShotDamageMult));
			}
			if (blast.lastShot > 0.0) {
				output.append("\nBlast Last Shot Damage :: " + f.format(blast.lastShot * (1 + finalLastShotDamageMult) / finalLastShotDamageMult));
			}
			if (magnetic.lastShot > 0.0) {
				output.append("\nMagnetic Last Shot Damage :: " + f.format(magnetic.lastShot * (1 + finalLastShotDamageMult) / finalLastShotDamageMult));
			}
			if (gas.lastShot > 0.0) {
				output.append("\nGas Last Shot Damage :: " + f.format(gas.lastShot * (1 + finalLastShotDamageMult) / finalLastShotDamageMult));
			}
			if (radiation.lastShot > 0.0) {
				output.append("\nRadiation Last Shot Damage :: " + f.format(radiation.lastShot * (1 + finalLastShotDamageMult) / finalLastShotDamageMult));
			}
			if (corrosive.lastShot > 0.0) {
				output.append("\nCorrosive Last Shot Damage :: " + f.format(corrosive.lastShot * (1 + finalLastShotDamageMult) / finalLastShotDamageMult));
			}
			if (viral.lastShot > 0.0) {
				output.append("\nViral Last Shot Damage :: " + f.format(viral.lastShot * (1 + finalLastShotDamageMult) / finalLastShotDamageMult));
			}
			output.append("\nLast Shot Damage to Clone Flesh :: " + f.format(cloneFlesh.lastShot));
			output.append("\nLast Shot Damage to Ferrite Armor :: " + f.format(ferrite.lastShot));
			output.append("\nLast Shot Damage to Alloy Armor :: " + f.format(alloy.lastShot));
			output.append("\nLast Shot Damage to Mechanical :: " + f.format(mechanical.lastShot));
			output.append("\nLast Shot Damage to Corpus Flesh :: " + f.format(corpusFlesh.lastShot));
			output.append("\nLast Shot Damage to Shield :: " + f.format(shield.lastShot));
			output.append("\nLast Shot Damage to Proto Shield :: " + f.format(protoShield.lastShot));
			output.append("\nLast Shot Damage to Robotic :: " + f.format(robotic.lastShot));
			output.append("\nLast Shot Damage to Infested Flesh :: " + f.format(infestedFlesh.lastShot));
			output.append("\nLast Shot Damage to Fossilized :: " + f.format(fossilized.lastShot));
			output.append("\nLast Shot Damage to Sinew :: " + f.format(sinew.lastShot));
			output.append("\nLast Shot Damage to Corpus :: " + f.format(corpus.lastShot));
			output.append("\nLast Shot Damage to Grineer :: " + f.format(grineer.lastShot));
			output.append("\nLast Shot Damage to Infested :: " + f.format(infested.lastShot));
			output.append("\nLast Shot Damage to Corrupted :: " + f.format(corrupted.lastShot));
		}
		output.append("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		output.append("\nRaw Damage Per Second :: " + f.format(raw.perSecond));
		output.append("\nDamage Per Second to Clone Flesh :: " + f.format(cloneFlesh.perSecond));
		output.append("\nDamage Per Second to Ferrite Armor :: " + f.format(ferrite.perSecond));
		output.append("\nDamage Per Second to Alloy Armor :: " + f.format(alloy.perSecond));
		output.append("\nDamage Per Second to Mechanical :: " + f.format(mechanical.perSecond));
		output.append("\nDamage Per Second to Corpus Flesh :: " + f.format(corpusFlesh.perSecond));
		output.append("\nDamage Per Second to Shield :: " + f.format(shield.perSecond));
		output.append("\nDamage Per Second to Proto Shield :: " + f.format(protoShield.perSecond));
		output.append("\nDamage Per Second to Robotic :: " + f.format(robotic.perSecond));
		output.append("\nDamage Per Second to Infested Flesh :: " + f.format(infestedFlesh.perSecond));
		output.append("\nDamage Per Second to Fossilized :: " + f.format(fossilized.perSecond));
		output.append("\nDamage Per Second to Sinew :: " + f.format(sinew.perSecond));
		output.append("\nDamage Per Second to Corpus :: " + f.format(corpus.perSecond));
		output.append("\nDamage Per Second to Grineer :: " + f.format(grineer.perSecond));
		output.append("\nDamage Per Second to Infested :: " + f.format(infested.perSecond));
		output.append("\nDamage Per Second to Corrupted :: " + f.format(corrupted.perSecond));
		output.append("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		output.append("\nRaw Burst Damage Per Second :: " + f.format(raw.rawPerSecond));
		output.append("\nBurst Damage Per Second to Clone Flesh :: " + f.format(cloneFlesh.rawPerSecond));
		output.append("\nBurst Damage Per Second to Ferrite Armor :: " + f.format(ferrite.rawPerSecond));
		output.append("\nBurst Damage Per Second to Alloy Armor :: " + f.format(alloy.rawPerSecond));
		output.append("\nBurst Damage Per Second to Mechanical :: " + f.format(mechanical.rawPerSecond));
		output.append("\nBurst Damage Per Second to Corpus Flesh :: " + f.format(corpusFlesh.rawPerSecond));
		output.append("\nBurst Damage Per Second to Shield :: " + f.format(shield.rawPerSecond));
		output.append("\nBurst Damage Per Second to Proto Shield :: " + f.format(protoShield.rawPerSecond));
		output.append("\nBurst Damage Per Second to Robotic :: " + f.format(robotic.rawPerSecond));
		output.append("\nBurst Damage Per Second to Infested Flesh :: " + f.format(infestedFlesh.rawPerSecond));
		output.append("\nBurst Damage Per Second to Fossilized :: " + f.format(fossilized.rawPerSecond));
		output.append("\nBurst Damage Per Second to Sinew :: " + f.format(sinew.rawPerSecond));
		output.append("\nBurst Damage Per Second to Corpus :: " + f.format(corpus.rawPerSecond));
		output.append("\nBurst Damage Per Second to Grineer :: " + f.format(grineer.rawPerSecond));
		output.append("\nBurst Damage Per Second to Infested :: " + f.format(infested.rawPerSecond));
		output.append("\nBurst Damage Per Second to Corrupted :: " + f.format(corrupted.rawPerSecond));

		output.append("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		output.append(selectedWeapon.getModsOutput());
		output.append("\nCorrosive Projections: " + corrosiveProjectionBox.getSelectedItem());
		output.append("\nShieldDisruptions: " + shieldDisruptionBox.getSelectedItem());

		if (useComplexTTK) {
			output.append("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			String ttkTableHeader = "\nTarget Name";
			Font font = output.getFont();
			FontMetrics metric = output.getFontMetrics(font);
			int spaceWidth = metric.stringWidth(".");
			int nameFieldWidth = metric.stringWidth(longestTTKName);
			double nameDiff = (nameFieldWidth - metric.stringWidth("Target Name")) / spaceWidth;
			nameDiff = Math.ceil(nameDiff);
			nameDiff += 2;
			for (int i = 0; i < nameDiff; i++) {
				ttkTableHeader += ".";
			}
			ttkTableHeader += "|........TTK.......|....MinTTK.....|....MaxTTK";
			output.append(ttkTableHeader);
			String ttkTableSep = "\n";
			spaceWidth = metric.stringWidth("-");
			int headerWidth = metric.stringWidth(ttkTableHeader);
			int headerLength = headerWidth / spaceWidth;
			for (int i = 0; i < headerLength; i++) {
				ttkTableSep += "-";
			}
			output.append(ttkTableSep);

			int targetGroup = Integer.parseInt((String) targetGroupBox.getSelectedItem());
			Vector<TTKTarget> groupTargets = new Vector<TTKTarget>();
			for (TTKTarget target : theTTKManager.targets) {
				if (target.groups.contains(targetGroup)) {
					groupTargets.add(target);
				}
			}
			// Vector<TTKNamePair> TTKGraphVec = new Vector<TTKNamePair>();
			for (TTKTarget target : groupTargets) {
				output.append(target.printAdvancedData());
				// TTKGraphVec.add(target.getTTKNamePair());
			}
		}
	}

	/**
	 * Update the instant stats
	 */
	public static void updateStats() {
		if (!setup) {
			useComplexTTK = false;
			updateOutput = false;
			calculateDPS();
			updateOutput = true;

			DecimalFormat f = new DecimalFormat("#.###");
			double totalmult = finalProjectileCount * averageCritMult * startingCombo * avgHit * finalDeadAimMult * COMult * viralMult * headShotMult * headShotBonus * (1 + (finalFirstShotDamageMult + finalLastShotDamageMult) / finalMag);
			DPSPanel.impactField.setText(f.format(totalmult * (impact.finalBase + explosiveImpact.finalBase)));
			DPSPanel.punctureField.setText(f.format(totalmult * (puncture.finalBase + explosivePuncture.finalBase)));
			DPSPanel.slashField.setText(f.format(totalmult * (slash.finalBase + explosiveSlash.finalBase)));
			DPSPanel.fireField.setText(f.format(totalmult * (fire.finalBase + explosiveFire.finalBase)));
			DPSPanel.iceField.setText(f.format(totalmult * (ice.finalBase + explosiveIce.finalBase)));
			DPSPanel.electricField.setText(f.format(totalmult * (electric.finalBase + explosiveElectric.finalBase)));
			DPSPanel.toxinField.setText(f.format(totalmult * (toxin.finalBase + explosiveToxin.finalBase)));
			DPSPanel.blastField.setText(f.format(totalmult * (blast.finalBase + explosiveBlast.finalBase)));
			DPSPanel.magneticField.setText(f.format(totalmult * (magnetic.finalBase + explosiveMagnetic.finalBase)));
			DPSPanel.gasField.setText(f.format(totalmult * (gas.finalBase + explosiveGas.finalBase)));
			DPSPanel.radiationField.setText(f.format(totalmult * (radiation.finalBase + explosiveRadiation.finalBase)));
			DPSPanel.corrosiveField.setText(f.format(totalmult * (corrosive.finalBase + explosiveCorrosive.finalBase)));
			DPSPanel.viralField.setText(f.format(totalmult * (viral.finalBase + explosiveViral.finalBase)));
			DPSPanel.projectilesField.setText(f.format(finalProjectileCount));
			if (weaponMode.equals(Constants.CONTINUOUS)) {
				DPSPanel.projectilesField.setText(f.format(1));
			}
			DPSPanel.FRField.setText(f.format(finalFireRate));
			DPSPanel.CCField.setText(f.format(100 * (finalCritChance + finalComboCrit)) + "%");
			DPSPanel.CDField.setText(f.format(finalCritMult));
			DPSPanel.SCField.setText(f.format(100 * averageStatusChance) + "%");
			DPSPanel.magField.setText(f.format(finalMag));
			DPSPanel.reloadField.setText(f.format(finalReloadTime));
			DPSPanel.damageField.setText(f.format(totalmult * (raw.finalBase + explosiveRaw.finalBase)));
			DPSPanel.slashProcField.setText(f.format(bleedDoTDPS));
			DPSPanel.toxinProcField.setText(f.format(poisonDoTDPS));
			DPSPanel.gasProcField.setText(f.format(cloudDoTDPS));
			DPSPanel.electricProcField.setText(f.format(electricProcDPS));
			DPSPanel.fireProcField.setText(f.format(heatDoTDPS));
			DPSPanel.burstField.setText(f.format(raw.rawPerSecond));
			DPSPanel.sustainedField.setText(f.format(raw.perSecond));

			DPSPanel.corpusField.setText(f.format(corpus.perSecond));
			DPSPanel.grineerField.setText(f.format(grineer.perSecond));
			DPSPanel.infestedField.setText(f.format(infested.perSecond));
			DPSPanel.corruptedField.setText(f.format(corrupted.perSecond));

			DPSPanel.impactChanceField.setText(f.format(averageStatusChance * 100 * (impactProcRate + explosiveImpactProcRate)) + "%");
			DPSPanel.punctureChanceField.setText(f.format(averageStatusChance * 100 * (punctureProcRate + explosivePunctureProcRate)) + "%");
			DPSPanel.slashChanceField.setText(f.format(averageStatusChance * 100 * (slashProcRate + explosiveSlashProcRate)) + "%");
			DPSPanel.fireChanceField.setText(f.format(averageStatusChance * 100 * (fireProcRate + explosiveFireProcRate)) + "%");
			DPSPanel.iceChanceField.setText(f.format(averageStatusChance * 100 * (iceProcRate + explosiveIceProcRate)) + "%");
			DPSPanel.electricChanceField.setText(f.format(averageStatusChance * 100 * (electricProcRate + explosiveElectricProcRate)) + "%");
			DPSPanel.toxinChanceField.setText(f.format(averageStatusChance * 100 * (toxinProcRate + explosiveToxinProcRate)) + "%");
			DPSPanel.blastChanceField.setText(f.format(averageStatusChance * 100 * (blastProcRate + explosiveBlastProcRate)) + "%");
			DPSPanel.magneticChanceField.setText(f.format(averageStatusChance * 100 * (magneticProcRate + explosiveMagneticProcRate)) + "%");
			DPSPanel.gasChanceField.setText(f.format(averageStatusChance * 100 * (gasProcRate + explosiveGasProcRate)) + "%");
			DPSPanel.radiationChanceField.setText(f.format(averageStatusChance * 100 * (radiationProcRate + explosiveRadiationProcRate)) + "%");
			DPSPanel.corrosiveChanceField.setText(f.format(averageStatusChance * 100 * (corrosiveProcRate + explosiveCorrosiveProcRate)) + "%");
			DPSPanel.viralChanceField.setText(f.format(averageStatusChance * 100 * (viralProcRate + explosiveViralProcRate)) + "%");

			DPSPanel.burstPanel.setVisible(false);
			DPSPanel.reloadPanel.setVisible(false);
			DPSPanel.magPanel.setVisible(false);
			DPSPanel.impactPanel.setVisible(false);
			DPSPanel.puncturePanel.setVisible(false);
			DPSPanel.slashPanel.setVisible(false);
			DPSPanel.firePanel.setVisible(false);
			DPSPanel.icePanel.setVisible(false);
			DPSPanel.electricPanel.setVisible(false);
			DPSPanel.toxinPanel.setVisible(false);
			DPSPanel.blastPanel.setVisible(false);
			DPSPanel.magneticPanel.setVisible(false);
			DPSPanel.gasPanel.setVisible(false);
			DPSPanel.radiationPanel.setVisible(false);
			DPSPanel.corrosivePanel.setVisible(false);
			DPSPanel.viralPanel.setVisible(false);
			DPSPanel.slashProcPanel.setVisible(false);
			DPSPanel.toxinProcPanel.setVisible(false);
			DPSPanel.gasProcPanel.setVisible(false);
			DPSPanel.electricProcPanel.setVisible(false);
			DPSPanel.fireProcPanel.setVisible(false);
			DPSPanel.impactChancePanel.setVisible(false);
			DPSPanel.punctureChancePanel.setVisible(false);
			DPSPanel.slashChancePanel.setVisible(false);
			DPSPanel.fireChancePanel.setVisible(false);
			DPSPanel.iceChancePanel.setVisible(false);
			DPSPanel.electricChancePanel.setVisible(false);
			DPSPanel.toxinChancePanel.setVisible(false);
			DPSPanel.blastChancePanel.setVisible(false);
			DPSPanel.magneticChancePanel.setVisible(false);
			DPSPanel.gasChancePanel.setVisible(false);
			DPSPanel.radiationChancePanel.setVisible(false);
			DPSPanel.corrosiveChancePanel.setVisible(false);
			DPSPanel.viralChancePanel.setVisible(false);
			DPSPanel.corpusPanel.setVisible(false);
			DPSPanel.grineerPanel.setVisible(false);
			DPSPanel.infestedPanel.setVisible(false);
			DPSPanel.corruptedPanel.setVisible(false);

			if (!selectedWeapon.weaponType.equals(Constants.MELEE)) {
				DPSPanel.reloadPanel.setVisible(true);
				DPSPanel.magPanel.setVisible(true);
				DPSPanel.burstPanel.setVisible(true);
			}
			if (impact.finalBase > 0 || explosiveImpact.finalBase > 0) {
				DPSPanel.impactPanel.setVisible(true);
				DPSPanel.impactChancePanel.setVisible(true);
			}
			if (puncture.finalBase > 0 || explosivePuncture.finalBase > 0) {
				DPSPanel.puncturePanel.setVisible(true);
				DPSPanel.punctureChancePanel.setVisible(true);
			}
			if (slash.finalBase > 0 || explosiveSlash.finalBase > 0) {
				DPSPanel.slashPanel.setVisible(true);
				DPSPanel.slashChancePanel.setVisible(true);
			}
			if (fire.finalBase > 0 || explosiveFire.finalBase > 0) {
				DPSPanel.firePanel.setVisible(true);
				DPSPanel.fireChancePanel.setVisible(true);
			}
			if (ice.finalBase > 0 || explosiveIce.finalBase > 0) {
				DPSPanel.icePanel.setVisible(true);
				DPSPanel.iceChancePanel.setVisible(true);
			}
			if (electric.finalBase > 0 || explosiveElectric.finalBase > 0) {
				DPSPanel.electricPanel.setVisible(true);
				DPSPanel.electricChancePanel.setVisible(true);
			}
			if (toxin.finalBase > 0 || explosiveToxin.finalBase > 0) {
				DPSPanel.toxinPanel.setVisible(true);
				DPSPanel.toxinChancePanel.setVisible(true);
			}
			if (blast.finalBase > 0 || explosiveBlast.finalBase > 0) {
				DPSPanel.blastPanel.setVisible(true);
				DPSPanel.blastChancePanel.setVisible(true);
			}
			if (magnetic.finalBase > 0 || explosiveMagnetic.finalBase > 0) {
				DPSPanel.magneticPanel.setVisible(true);
				DPSPanel.magneticChancePanel.setVisible(true);
			}
			if (gas.finalBase > 0 || explosiveGas.finalBase > 0) {
				DPSPanel.gasPanel.setVisible(true);
				DPSPanel.gasChancePanel.setVisible(true);
			}
			if (radiation.finalBase > 0 || explosiveRadiation.finalBase > 0) {
				DPSPanel.radiationPanel.setVisible(true);
				DPSPanel.radiationChancePanel.setVisible(true);
			}
			if (corrosive.finalBase > 0 || explosiveCorrosive.finalBase > 0) {
				DPSPanel.corrosivePanel.setVisible(true);
				DPSPanel.corrosiveChancePanel.setVisible(true);
			}
			if (viral.finalBase > 0 || explosiveViral.finalBase > 0) {
				DPSPanel.viralPanel.setVisible(true);
				DPSPanel.viralChancePanel.setVisible(true);
			}
			if (bleedDoTDPS > 0) {
				DPSPanel.slashProcPanel.setVisible(true);
			}
			if (poisonDoTDPS > 0) {
				DPSPanel.toxinProcPanel.setVisible(true);
			}
			if (cloudDoTDPS > 0) {
				DPSPanel.gasProcPanel.setVisible(true);
			}
			if (electricProcDPS > 0) {
				DPSPanel.electricProcPanel.setVisible(true);
			}
			if (heatDoTDPS > 0) {
				DPSPanel.fireProcPanel.setVisible(true);
			}
			String faction = "";
			Double factionMult = 1.0;
			if (finalCorpusMult > 1) {
				DPSPanel.corpusPanel.setVisible(true);
				faction = "to Corpus";
				factionMult = finalCorpusMult;
			}
			if (finalGrineerMult > 1) {
				DPSPanel.grineerPanel.setVisible(true);
				faction = "to Grineer";
				factionMult = finalGrineerMult;
			}
			if (finalInfestedMult > 1) {
				DPSPanel.infestedPanel.setVisible(true);
				faction = "to Infested";
				factionMult = finalInfestedMult;
			}
			if (finalCorruptedMult > 1) {
				DPSPanel.corruptedPanel.setVisible(true);
				faction = "to Infested";
				factionMult = finalInfestedMult;
			}
			DPSPanel.slashProcField.setToolTipText(f.format(factionMult * factionMult * (bleedDoTDPS) / slashStacks) + " Damage per tick" + faction);
			DPSPanel.toxinProcField.setToolTipText(f.format(factionMult * factionMult * (poisonDoTDPS) / toxinStacks) + " Damage per tick" + faction);
			DPSPanel.gasProcField.setToolTipText(f.format(factionMult * factionMult * (cloudDoTDPS) / gasStacks) + " Damage per tick" + faction);
			DPSPanel.fireProcField.setToolTipText(f.format(factionMult * factionMult * (heatDoTDPS) / fireStacks) + " Damage per tick" + faction);
		}
		useComplexTTK = true;

		repack();
	}

	/**
	 * Method to display the mod manager
	 */
	protected static void displayModManager() {

		if (!modManagerInit) {
			modManagerInit = true;
			theModManager.Init();
			modManagerFrame.add(theModManager);
			modManagerFrame.pack();
			modManagerFrame.addWindowListener(new ModWindowListener());
			modManagerFrame.setTitle("Mod Manager");
			modManagerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		modManagerFrame.setVisible(true);
	}

	/**
	 * Method to display the weapon manager
	 */
	protected static void displayWeaponManager() {

		if (!weaponManagerInit) {
			weaponManagerInit = true;
			weaponManagerFrame.add(theWeaponManager);
			weaponManagerFrame.pack();
			weaponManagerFrame.addWindowListener(new WeaponWindowListener());
			weaponManagerFrame.setTitle("Weapon Manager");
			weaponManagerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		weaponManagerFrame.setVisible(true);
	}

	/**
	 * Method to display the target manager
	 */
	protected static void displayTargetManager() {
		if (!targetManagerInit) {
			targetManagerInit = true;
			targetManagerFrame.add(theTTKManager);
			targetManagerFrame.pack();
			targetManagerFrame.addWindowListener(new TTKWindowListener());
			targetManagerFrame.setTitle("Target Manager");
			targetManagerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		targetManagerFrame.setVisible(true);
	}

	/**
	 * Method to display the color options manager
	 */
	protected static void displayColorOptions() {
		if (!colorOptionsInit) {
			colorOptionsInit = true;
			colorOptionsFrame.add(theColorPanel);
			colorOptionsFrame.pack();
			colorOptionsFrame.setTitle("Color Options");
			colorOptionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		colorOptionsFrame.setVisible(true);
	}

	/**
	 * Method to display the stance manager
	 */
	protected static void displayStanceManager() {
		if (!stanceManagerInit) {
			stanceManagerInit = true;
			stanceManagerFrame.add(theStanceManager);
			stanceManagerFrame.pack();
			stanceManagerFrame.addWindowListener(new StanceWindowListener());
			stanceManagerFrame.setTitle("Stance Manager");
			stanceManagerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		stanceManagerFrame.setVisible(true);
	}

	/**
	 * Method to toggle the enabled state of the mod manager menu item
	 */
	protected static void updateModMenuState(boolean enabled) {
		modMenu.setEnabled(enabled);
	}

	/**
	 * Method to toggle the enabled state of the target manager menu item
	 */
	protected static void updateTTKMenuState(boolean enabled) {
		TTKMenu.setEnabled(enabled);
		quickTargetButton.setEnabled(enabled);
		removeTargetButton.setEnabled(enabled);
	}

	/**
	 * Method to toggle the enabled state of the weapon manager menu item
	 */
	protected static void updateWeaponMenuState(boolean enabled) {
		weaponMenu.setEnabled(enabled);
	}

	/**
	 * Method to toggle the enabled state of the stance manager menu item
	 */
	protected static void updateStanceMenuState(boolean enabled) {
		stanceMenu.setEnabled(enabled);
	}

	/**
	 * ____________________________________________________________ INTERNAL CLASSES
	 * ____________________________________________________________
	 */

	/**
	 * change Listener Local Class
	 */
	protected static class MainChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			updateStats();
		}
	}

	/**
	 * Action Listener Local Class
	 * 
	 * @author GottFuast
	 *
	 */
	public static class MainActionListener implements ActionListener {
		/**
		 * Default CTOR
		 */
		public MainActionListener() {
			// Do Nothing
		}

		/**
		 * Action Listener Callback
		 */
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(calculateButton)) {
				updateOutput = true;
				useComplexTTK = true;
				calculateDPS();
			} else if (e.getSource().equals(maximizeButton)) {
				selectedWeapon = (WeaponPanel) weaponPane.getSelectedComponent();
				loadingScreen.setVisible(true);
				progressBar.setValue(0);
				useComplexTTK = true;
				updateOutput = false;
				setup = true;
				maxxing = true;
				theMaximizer = new Maximizer();

				new Thread(new Runnable() {
					public void run() {
						theMaximizer.Maximize();
						loadingScreen.setVisible(false);
						setup = false;
						maxxing = false;
					}
				}).start();

			} else if (e.getSource().equals(stopButton)) {
				stop = true;
			} else if (e.getSource().equals(quickTargetButton)) {
				displayTargetManager();
				updateTTKMenuState(false);
				quickGroup = true;
				theTTKManager.targetGroupPanel.setVisible(false);
				theTTKManager.deleteButton.setVisible(false);
				theTTKManager.saveButton.setVisible(false);
			} else if (e.getSource().equals(removeTargetButton)) {
				if (enemyList.getSelectedIndex() >= 0) {
					String targetName = (String) enemyListModel.get(enemyList.getSelectedIndex());
					TTKTarget selectedTarget = theTTKManager.getTargetByName(targetName);
					TTKTarget foundTarget = theTTKManager.getTargetByName(targetName);
					if (theTTKManager.targets.contains(selectedTarget)) {
						for (int i = 0; i < selectedTarget.groups.size(); i++) {
							if (selectedTarget.groups.get(i) == targetGroupBox.getSelectedIndex()) {
								selectedTarget.groups.remove(i);
								break;
							}
						}
						theTTKManager.targets.set(theTTKManager.targets.indexOf(foundTarget), selectedTarget);
					}
					updateTargetList();
					theTTKManager.updateTargetList();
				}

			} else if (e.getSource().equals(targetGroupBox)) {
				updateTargetList();
			} else if (e.getSource().equals(clearOutputButton)) {
				output.setText("");
			} else if (e.getSource().equals(headShots)) {
				updateStats();
			} else if (e.getSource().equals(loadItem)) {
				int returnVal = chooser.showOpenDialog(mainPanel);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					setup = true;
					riflePanel.clear();
					shotgunPanel.clear();
					pistolPanel.clear();
					meleePanel.clear();
					clearValues();
					File file = chooser.getSelectedFile();
					try {
						BufferedReader reader = new BufferedReader(new FileReader(file));
						String header = reader.readLine();
						reader.close();
						if (header.equals(Constants.RIFLE)) {
							weaponPane.setSelectedIndex(weaponPane.indexOfTab(Constants.RIFLE));
							riflePanel.loadFromFile(file);
						} else if (header.equals(Constants.PISTOL)) {
							weaponPane.setSelectedIndex(weaponPane.indexOfTab(Constants.PISTOL));
							pistolPanel.loadFromFile(file);
						} else if (header.equals(Constants.SHOTGUN)) {
							weaponPane.setSelectedIndex(weaponPane.indexOfTab(Constants.SHOTGUN));
							shotgunPanel.loadFromFile(file);
						} else if (header.equals(Constants.ARCHGUN)) {
							weaponPane.setSelectedIndex(weaponPane.indexOfTab(Constants.ARCHGUN));
							arcGunPanel.loadFromFile(file);
						} else if (header.equals(Constants.MELEE)) {
							weaponPane.setSelectedIndex(weaponPane.indexOfTab(Constants.MELEE));
							meleePanel.loadFromFile(file);
						}
					} catch (Exception ex) {
						// Do Nothing
					}
					setup = false;
					updateStats();
				} else {
					// Do Nothing
				}
			} else if (e.getSource().equals(saveItem)) {
				int returnVal = chooser.showSaveDialog(mainPanel);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					if (!file.getAbsolutePath().endsWith(".wdc")) {
						file = new File(file.getAbsolutePath() + ".wdc");
					}
					WeaponPanel selected = (WeaponPanel) weaponPane.getSelectedComponent();
					selected.saveToFile(file);
				} else {
					// Do Nothing
				}
			} else if (e.getSource().equals(modMenu)) {
				displayModManager();
				updateModMenuState(false);
			} else if (e.getSource().equals(TTKMenu)) {
				displayTargetManager();
				updateTTKMenuState(false);
				quickGroup = false;
				theTTKManager.targetGroupPanel.setVisible(true);
				theTTKManager.deleteButton.setVisible(true);
				theTTKManager.saveButton.setVisible(true);
			} else if (e.getSource().equals(weaponMenu)) {
				displayWeaponManager();
				updateWeaponMenuState(false);
			} else if (e.getSource().equals(stanceMenu)) {
				displayStanceManager();
				updateStanceMenuState(false);
			} else if (e.getSource().equals(colorOptionsItem)) {
				displayColorOptions();
			}
		}
	}

	public static double getCorrosiveProjectionMult() {
		double mult = 1.0 - (0.18 * Double.parseDouble((String) corrosiveProjectionBox.getSelectedItem()));
		if (mult < 0.0) {
			mult = 0.0;
		}
		return mult;
	}

	public static double getShieldDisruptionMult() {
		double mult = 1.0 - (0.24 * Double.parseDouble((String) shieldDisruptionBox.getSelectedItem()));
		return mult;
	}

	public static void repack() {
		mainFrame.pack();
	}

	/**
	 * Window Listener Local Class
	 * 
	 * @author GottFuast
	 *
	 */
	protected static class MainWindowListener implements WindowListener {

		/**
		 * Default CTOR
		 */
		public MainWindowListener() {
			// Do Nothing
		}

		/**
		 * Event to indicate that the window has closed
		 */
		public void windowClosed(WindowEvent e) {
			System.exit(0);
		}

		/**
		 * Event to indicate taht the window is closing
		 */
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

		/**
		 * Unused
		 */
		public void windowActivated(WindowEvent e) {
		}

		public void windowDeactivated(WindowEvent e) {
		}

		public void windowDeiconified(WindowEvent e) {
		}

		public void windowIconified(WindowEvent e) {
		}

		public void windowOpened(WindowEvent e) {
		}
	}

	/**
	 * Window Listener Local Class
	 * 
	 * @author GottFaust
	 *
	 */
	protected static class ModWindowListener implements WindowListener {

		/**
		 * Default CTOR
		 */
		public ModWindowListener() {
			// Do Nothing
		}

		/**
		 * Event to indicate that the window has closed
		 */
		public void windowClosed(WindowEvent e) {
			updateModMenuState(true);
		}

		/**
		 * Unused
		 */
		public void windowActivated(WindowEvent e) {
		}

		public void windowClosing(WindowEvent e) {
		}

		public void windowDeactivated(WindowEvent e) {
		}

		public void windowDeiconified(WindowEvent e) {
		}

		public void windowIconified(WindowEvent e) {
		}

		public void windowOpened(WindowEvent e) {
		}
	}

	/**
	 * Window Listener Local Class
	 * 
	 * @author GottFaust
	 *
	 */
	protected static class TTKWindowListener implements WindowListener {

		/**
		 * Default CTOR
		 */
		public TTKWindowListener() {
			// Do Nothing
		}

		/**
		 * Event to indicate that the window has closed
		 */
		public void windowClosed(WindowEvent e) {
			updateTTKMenuState(true);
		}

		/**
		 * Unused
		 */
		public void windowActivated(WindowEvent e) {
		}

		public void windowClosing(WindowEvent e) {
		}

		public void windowDeactivated(WindowEvent e) {
		}

		public void windowDeiconified(WindowEvent e) {
		}

		public void windowIconified(WindowEvent e) {
		}

		public void windowOpened(WindowEvent e) {
		}
	}

	/**
	 * Window Listener Local Class
	 * 
	 * @author GottFaust
	 *
	 */
	protected static class WeaponWindowListener implements WindowListener {

		/**
		 * Default CTOR
		 */
		public WeaponWindowListener() {
			// Do Nothing
		}

		/**
		 * Event to indicate that the window has closed
		 */
		public void windowClosed(WindowEvent e) {
			updateWeaponMenuState(true);
		}

		/**
		 * Unused
		 */
		public void windowActivated(WindowEvent e) {
		}

		public void windowClosing(WindowEvent e) {
		}

		public void windowDeactivated(WindowEvent e) {
		}

		public void windowDeiconified(WindowEvent e) {
		}

		public void windowIconified(WindowEvent e) {
		}

		public void windowOpened(WindowEvent e) {
		}
	}

	protected static class StanceWindowListener implements WindowListener {

		/**
		 * Default CTOR
		 */
		public StanceWindowListener() {
			// Do Nothing
		}

		/**
		 * Event to indicate that the window has closed
		 */
		public void windowClosed(WindowEvent e) {
			updateStanceMenuState(true);
		}

		/**
		 * Unused
		 */
		public void windowActivated(WindowEvent e) {
		}

		public void windowClosing(WindowEvent e) {
		}

		public void windowDeactivated(WindowEvent e) {
		}

		public void windowDeiconified(WindowEvent e) {
		}

		public void windowIconified(WindowEvent e) {
		}

		public void windowOpened(WindowEvent e) {
		}
	}

	static BigInteger binomial(final int N, final int K) {
		BigInteger ret = BigInteger.ONE;
		for (int k = 0; k < K; k++) {
			ret = ret.multiply(BigInteger.valueOf(N - k)).divide(BigInteger.valueOf(k + 1));
		}
		return ret;
	}
	
	static double replaceNaN(double n) {
		if (Double.isNaN(n)) {
			n = 1;
		}
		return n;
	}
}
