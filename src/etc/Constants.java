package etc;

public class Constants {
  
  /** Mod Type Constants **/
  public static final String MOD_TYPE_DAMAGE_BONUS = "DamageBonus";
  public static final String MOD_TYPE_FIRE_DAMAGE = "FireDamage";
  public static final String MOD_TYPE_LIGHTNING_DAMAGE = "LightningDamage";
  public static final String MOD_TYPE_ICE_DAMAGE = "IceDamage";
  public static final String MOD_TYPE_PUNCTURE_DAMAGE = "PunctureDamage";
  public static final String MOD_TYPE_TOXIN_DAMAGE = "ToxinDamage";
  public static final String MOD_TYPE_IMPACT_DAMAGE = "ImpactDamage";
  public static final String MOD_TYPE_SLASH_DAMAGE = "SlashDamage";
  public static final String MOD_TYPE_MISC_DAMAGE = "MiscDamage";
  public static final String MOD_TYPE_MULTISHOT = "Multishot";
  public static final String MOD_TYPE_FIRE_RATE = "FireRate";
  public static final String MOD_TYPE_RELOAD_SPEED = "ReladSpeed";
  public static final String MOD_TYPE_MAG_CAP = "MagCap";
  public static final String MOD_TYPE_AMMO_CAP = "AmmoCap";
  public static final String MOD_TYPE_CORPUS_DAMAGE = "CorpusDamage";
  public static final String MOD_TYPE_GRINEER_DAMAGE = "GrineerDamage";
  public static final String MOD_TYPE_INFESTED_DAMAGE = "InfestedDamage";
  public static final String MOD_TYPE_CRIT_CHANCE = "CritChance";
  public static final String MOD_TYPE_CRIT_MULTIPLIER = "CritMultiplier";
  public static final String MOD_TYPE_STATUS_CHANCE = "StatusChance";
  public static final String MOD_TYPE_STATUS_DURATION = "StatusDuration";
  public static final String MOD_TYPE_FIRST_SHOT_DAMAGE = "FirstShotDamage";
  public static final String MOD_TYPE_ZOOM = "Zoom";
  public static final String MOD_TYPE_OBJECT_PIERCE = "ObjectPierce";
  public static final String MOD_TYPE_AMMO_MUTATOR = "AmmoMutator";
  public static final String MOD_TYPE_ACCURACY = "AccuracyBonus";
  public static final String MOD_TYPE_RECOIL = "RecoilBonus";
  public static final String MOD_TYPE_SPREAD = "SpreadBonus";
  public static final String MOD_TYPE_SILENCE = "Silence";
  public static final String MOD_TYPE_FLAT_DAMAGE = "FlatDamageBonus";
  public static final String MOD_TYPE_DEAD_AIM = "DeadAim";
  public static final String MOD_TYPE_FLAT_STATUS = "FlatStatusBonus";
  public static final String MOD_TYPE_FLAT_MAG = "FlatMagBonus";
  public static final String MOD_TYPE_MUNITIONS = "Munitions";
  
  /** Damage Types **/
  public static final String PHYSICAL_WEAPON_DAMAGE = "Physical";
  public static final String IMPACT_WEAPON_DAMAGE = "Impact";
  public static final String PUNCTURE_WEAPON_DAMAGE = "Puncture";
  public static final String SLASH_WEAPON_DAMAGE = "Slash";
  public static final String FIRE_WEAPON_DAMAGE = "Fire";
  public static final String ICE_WEAPON_DAMAGE = "Ice";
  public static final String ELECTRIC_WEAPON_DAMAGE = "Electric";
  public static final String TOXIN_WEAPON_DAMAGE = "Toxin";
  public static final String BLAST_WEAPON_DAMAGE = "Blast";
  public static final String MAGNETIC_WEAPON_DAMAGE = "Magnetic";
  public static final String GAS_WEAPON_DAMAGE = "Gas";
  public static final String RADIATION_WEAPON_DAMAGE = "Radiation";
  public static final String CORROSIVE_WEAPON_DAMAGE = "Corrosive";
  public static final String VIRAL_WEAPON_DAMAGE = "Viral";
  
  public static final String NO_WEAPON_DAMAGE = "None";
  
  /** Weapon Modes **/
  public static final String BURST = "Burst";
  public static final String CHARGE = "Charge";
  public static final String CONTINUOUS = "Continuous";
  public static final String FULL_AUTO = "Full-Auto";
  public static final String FULL_AUTO_RAMP_UP = "Full-Auto (Ramp-up)";
  public static final String FULL_AUTO_BULLET_RAMP = "Full-Auto (Bullet-Ramp)";
  public static final String SEMI_AUTO = "Semi-Auto";
  
  /** Frame Title **/
  public static final String APP_TITLE = "Warframe Weapon DPS Calculator";
  public static final String APP_VERSION = "v0.9.4";
  
  /** ToolTips **/
  public static final String NAME_TOOL_TIP = "The weapon's name.";
  public static final String DAMAGE_TOOL_TIP = "The weapon's base damage.";
  public static final String IMPACT_TOOL_TIP = "The weapon's impact damage.";
  public static final String PUNCTURE_TOOL_TIP = "The weapon's puncture damage.";
  public static final String SLASH_TOOL_TIP = "The weapon's slash damage.";
  public static final String POJECTILE_TOOL_TIP = "The number of projectiles fired per shot";
  public static final String CONTINUOUS_DAMAGE_TOOL_TIP = "The base damage displayed by the weapon.";
  public static final String FIRE_RATE_TOOL_TIP = "The weapon's fire rate in bullets per seconds.";
  public static final String MAG_SIZE_TOOL_TIP = "<HTML>The weapon's magazine size. <br>Depending on the weapon, this can also be referred to as clip size.<HTML>";
  public static final String TOTAL_AMMO_TOOL_TIP = "The weapons's total available ammo not including the first mag.";
  public static final String RELOAD_TIME_TOOL_TIP = "The weapon's reload time in seconds";
  public static final String CRIT_CHANCE_TOOL_TIP = "<HTML>The weapon's critical chance in whole number percents. <br>For example, the Lanka has a 20 base crit chance.</HTML>";
  public static final String CRIT_MULT_TOOL_TIP = "<HTML>The Weapon's critical damage multiplier in decimal format. <br>For example, the Lanka has a 1.5 base crit multiplier.</HTML>";
  public static final String WEAPON_MODE_TOOL_TIP = "The weapon's mode of operation.";
  public static final String DAMAGE_TYPE_TOOL_TIP = "<HTML>The type of base damage that this weapon does. <br>This info can be obtained most easily from the warframe wiki.</HTML>";
  public static final String CHARGE_TIME_TOOL_TIP = "The time it takes the weapon to charge before being able to fire.";
  public static final String BURST_COUNT_TOOL_TIP = "The number of bullets fired in each burst.";
  public static final String BURST_FIRE_RATE_TOOL_TIP = "The rate of fire during each burst iteration";
  public static final String STATUS_TOOL_TIP = "The base status chance of this weapon.";
  
  /** Weapon Types **/
  public static final String SHOTGUN = "Shotgun";
  public static final String RIFLE = "Rifle";
  public static final String PISTOL = "Pistol";
  public static final String ARCGUN = "ArcGun";
  
  /** Mod Effect Count **/
  public static final String SINGLE = "Single";
  public static final String DOUBLE = "Double";
  public static final String TRIPLE = "Triple";
  public static final String QUAD = "Quad";
  
  /** Mod Polarities **/
  public static final String NONE = "None";
  public static final String DASH = "~";
  public static final String EQUALS = "=";
  public static final String D = "D";
  public static final String V = "V";
  
  /** UI Text Values **/
  public static final String MOD_LABEL = "Mod:";
  public static final String RANK_LABEL = "Rank:";
  public static final String SLOT_POLARITY_LABEL = ":Pol:";
  public static final String MOD_POLARITY_LABEL = "Mod-Pol:";
  public static final String COST_LABEL = ":Cost:";
  public static final String CUSTOM_WEAPON = "Custom";
  
  /** Enemy Values **/
  public static final String ENEMY_TYPE_INFESTED = "Infested";
  public static final String ENEMY_TYPE_CORPUS = "Corpus";
  public static final String ENEMY_TYPE_GRINEER = "Grineer";
  public static final String ENEMY_SURFACE_CLONE_FLESH = "CloneFlesh";
  public static final String ENEMY_SURFACE_FERRITE_ARMOR = "FerriteArmor";
  public static final String ENEMY_SURFACE_ALLOY_ARMOR = "AlloyArmor";
  public static final String ENEMY_SURFACE_MECHANICAL = "Mechanical";
  public static final String ENEMY_SURFACE_CORPUS_FLESH = "CorpusFlesh";
  public static final String ENEMY_SURFACE_PROTO_SHIELD = "ProtoShield";
  public static final String ENEMY_SURFACE_INFESTED_FLESH = "InfestedFlesh";
  public static final String ENEMY_SURFACE_FOSSILIZED = "Fossilized";
  public static final String ENEMY_SURFACE_SINEW = "Sinew";
  public static final String ENEMY_SURFACE_SHIELDS = "Shields";
  public static final String ENEMY_SURFACE_ROBOTIC = "Robotic";
  public static final String ENEMY_SURFACE_INFESTED = "Infested";
  
  /** Color Names **/
  public static final String CONTAINER_BACKGROUND_COLOR_NAME = "Container Background";
  public static final String TEXT_AREA_BACKGROUND_COLOR_NAME = "Text Field Background";
  public static final String BUTTON_BACKGROUND_COLOR_NAME = "Button Background";
  public static final String GRAPH_DEMARCATION_COLOR_NAME = "Graph Line";
  public static final String TEXT_FOREGROUND_COLOR_NAME = "Text";
  public static final String BUTTON_FOREGROUND_COLOR_NAME = "Button Text";
  public static final String LABEL_FOREGROUND_COLOR_NAME = "Label Text";
  public static final String BORDER_COLOR_NAME = "Borders";
  public static final String LIGHER_BORDER_COLOR_NAME = "Mod Borders";
  public static final String CURRENT_GRAPH_COLOR_NAME = "Current DPS Graph";
  public static final String PREVIOUS_GRAPH_COLOR_NAME = "Previous DPS Graph";
  
  /** Default Color options for use if the file is missing **/
  public static final String[] baseColorOptions = { CONTAINER_BACKGROUND_COLOR_NAME+";44,44,44",
                                                    TEXT_AREA_BACKGROUND_COLOR_NAME+";0,0,0",
                                                    BUTTON_BACKGROUND_COLOR_NAME+";0,0,0",
                                                    GRAPH_DEMARCATION_COLOR_NAME+";124,124,124",
                                                    TEXT_FOREGROUND_COLOR_NAME+";0,255,0",
                                                    BUTTON_FOREGROUND_COLOR_NAME+";0,255,0",
                                                    LABEL_FOREGROUND_COLOR_NAME+";0,204,0",
                                                    BORDER_COLOR_NAME+";255,255,0",
                                                    LIGHER_BORDER_COLOR_NAME+";0,255,0",
                                                    CURRENT_GRAPH_COLOR_NAME+";255,255,0",
                                                    PREVIOUS_GRAPH_COLOR_NAME+";124,124,124"};
  
  /** Default TTK Targets for use if the file is missing**/
  public static final String[] baseTTKTargets = { "Corpus Tech,15,95,0,700,250,CorpusFlesh,FerriteArmor,ProtoShield,Corpus,0",
                                                  "Toxic Ancient,1,95,0,400,0,Fossilized,FerriteArmor,Shields,Infested,0",
                                                  "Heavy Gunner,8,95,500,300,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,0",
                                                  "Fusion Moa,15,95,0,250,250,Robotic,FerriteArmor,Shields,Corpus,0",
                                                  "Corrupted Butcher,1,95,5,100,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,4",
                                                  "Corrupted Lancer,1,95,200,60,0,CloneFlesh,AlloyArmor,ProtoShield,Grineer,4",
                                                  "Corrupted Crewman,1,95,0,60,150,CorpusFlesh,AlloyArmor,Shields,Grineer,4",
                                                  "Corrupted Nullifier,1,95,0,60,150,CorpusFlesh,AlloyArmor,ProtoShield,Grineer,4",
                                                  "Corrupted MOA,1,95,0,250,250,Robotic,AlloyArmor,Shields,Grineer,4",
                                                  "Corrupted Ancient,1,95,0,400,0,Fossilized,AlloyArmor,ProtoShield,Grineer,4",
                                                  "Corrupted Heavy Gunner,8,95,500,700,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,4",
                                                  "Corrupted Bombard,4,95,500,300,0,CloneFlesh,AlloyArmor,ProtoShield,Grineer,4",
                                                  "Corrupted Heavy Gunner Leech Eximus,8,95,800,2100,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,4",
                                                  "Corrupted Bombard Leech Eximus,4,95,800,900,0,CloneFlesh,AlloyArmor,ProtoShield,Grineer,4",
                                                  "Butcher,1,95,5,50,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,1",
                                                  "Scorpion,10,95,150,150,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,1",
                                                  "Elite Lancer,15,95,200,150,0,CloneFlesh,AlloyArmor,ProtoShield,Grineer,1",
                                                  "Trooper,1,95,150,120,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,1",
                                                  "Ballista,1,95,100,100,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,1",
                                                  "Scorch,10,95,100,120,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,1",
                                                  "Seeker,1,95,200,100,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,1",
                                                  "Drahk Master,12,95,200,500,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,1",
                                                  "Drahk,1,95,175,300,0,CorpusFlesh,FerriteArmor,ProtoShield,Grineer,1",
                                                  "Napalm,6,95,500,600,0,CloneFlesh,AlloyArmor,ProtoShield,Grineer,1",
                                                  "Heavy Gunner,8,95,500,300,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,1",
                                                  "Bombard,1,95,500,300,0,CloneFlesh,AlloyArmor,ProtoShield,Grineer,1",
                                                  "Napalm Leech Eximus,6,95,800,1800,0,CloneFlesh,AlloyArmor,ProtoShield,Grineer,1",
                                                  "Heavy Gunner Leech Eximus,8,95,800,900,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,1",
                                                  "Prod Crewman,1,95,0,100,50,CorpusFlesh,AlloyArmor,Shields,Corpus,2",
                                                  "Crewman,1,95,0,60,150,CorpusFlesh,AlloyArmor,Shields,Corpus,2",
                                                  "Sniper Crewman,15,95,0,60,150,CorpusFlesh,AlloyArmor,ProtoShield,Corpus,2",
                                                  "Elite Crewman,15,95,0,100,200,CorpusFlesh,AlloyArmor,Shields,Corpus,2",
                                                  "Tech,15,95,0,700,250,CorpusFlesh,AlloyArmor,ProtoShield,Corpus,2",
                                                  "Nullifer Crewman,1,95,0,600,150,CorpusFlesh,AlloyArmor,ProtoShield,Corpus,2",
                                                  "MOA,1,95,0,60,150,Robotic,AlloyArmor,Shields,Corpus,2",
                                                  "Fusion MOA,15,95,0,250,250,Robotic,AlloyArmor,Shields,Corpus,2",
                                                  "Fusion MOA Drone,15,95,0,250,75,Robotic,AlloyArmor,Shields,Corpus,2",
                                                  "Anti MOA,5,95,0,50,500,Robotic,AlloyArmor,Shields,Corpus,2",
                                                  "Oxium Osprey,1,95,0,750,150,Robotic,AlloyArmor,Shields,Corpus,2",
                                                  "Bursa,1,95,350,2500,2400,Robotic,FerriteArmor,Shields,Corpus,2",
                                                  "Charger,1,95,0,80,0,Infested,AlloyArmor,ProtoShield,Infested,3",
                                                  "Volatile Runner,1,95,0,80,0,InfestedFlesh,AlloyArmor,ProtoShield,Infested,3",
                                                  "Runner,1,95,0,100,0,Infested,AlloyArmor,ProtoShield,Infested,3",
                                                  "Crawler,1,95,0,50,0,InfestedFlesh,AlloyArmor,ProtoShield,Infested,3",
                                                  "Ancient,1,95,0,400,0,Fossilized,AlloyArmor,ProtoShield,Infested,3",
                                                  "Mutalist Osprey,1,95,0,200,0,InfestedFlesh,AlloyArmor,ProtoShield,Infested,3",
                                                  "Mutalist MOA,0,95,0,350,0,Fossilized,AlloyArmor,ProtoShield,Infested,3",
                                                  "Brood Mother,1,95,0,700,0,Fossilized,AlloyArmor,ProtoShield,Infested,3",
                                                  "Boiler,1,95,0,1200,0,Fossilized,AlloyArmor,ProtoShield,Infested,3",
                                                  "Juggernaut,1,95,200,3500,0,Infested,FerriteArmor,ProtoShield,Infested,3"};
  
  /** The Default Mod DB for use if the file is missing **/
  public static final String[] baseModDB = {"Accelerated Blast,Shotgun,3,2,FireRate,PunctureDamage,0.15,0.15,V,6",
                                            "Ammo Drum,Rifle,5,1,AmmoCap,0.05,~,2",
                                            "Ammo Stock,Shotgun,5,1,MagCap,0.1,~,2",
                                            "Anemic Agility,Pistol,5,2,FireRate,DamageBonus,0.15,-0.025,~,4",
                                            "Arrow Mutation,Rifle,3,1,AmmoMutator,0.0,~,4",
                                            "Bane of Corpus,Rifle,5,1,CorpusDamage,0.05,V,4",
                                            "Bane of Grineer,Rifle,5,1,GrineerDamage,0.05,V,4",
                                            "Bane of Infested,Rifle,5,1,InfestedDamage,0.05,V,4",
                                            "Barrel Diffusion,Pistol,5,1,Multishot,0.2,V,6",
                                            "Blaze,Shotgun,3,2,DamageBonus,FireDamage,0.15,0.15,V,6",
                                            "Blunderbuss,Shotgun,5,1,CritChance,0.15,V,4",
                                            "Bore,Pistol,5,1,PunctureDamage,0.2,~,6",
                                            "Breach Loader,Shotgun,5,1,PunctureDamage,0.2,~,6",
                                            "Burdened Magazine,Shotgun,5,2,MagCap,ReladSpeed,0.1,-0.03,~,6",
                                            "Charged Chamber,Rifle,3,1,FirstShotDamage,0.1,V,6",
                                            "Charged Shell,Shotgun,5,1,LightningDamage,0.15,~,6",
                                            "Primed Charged Shell,Shotgun,10,1,LightningDamage,0.15,~,6",
                                            "Chilling Grasp,Shotgun,5,1,IceDamage,0.15,D,6",
                                            "Cleanse Corpus,Shotgun,5,1,CorpusDamage,0.05,V,4",
                                            "Cleanse Grineer,Shotgun,5,1,GrineerDamage,0.05,V,4",
                                            "Cleanse Infested,Shotgun,5,1,InfestedDamage,0.05,V,4",
                                            "Concussion Rounds,Pistol,5,1,ImpactDamage,0.1,~,2",
                                            "Contagious Spread,Shotgun,5,1,ToxinDamage,0.15,~,6",
                                            "Continuous Misery,Rifle,3,1,StatusDuration,0.25,V,4",
                                            "Convulsion,Pistol,5,1,LightningDamage,0.15,~,6",
                                            "Crash Course,Rifle,5,1,ImpactDamage,0.2,~,6",
                                            "Creeping Bullseye,Pistol,5,2,CritChance,FireRate,0.08,-0.06,~,4",
                                            "Critical Deceleration,Shotgun,5,2,CritChance,FireRate,0.08,-0.05,V,4",
                                            "Critical Delay,Rifle,5,2,CritChance,FireRate,0.08,-0.06,~,4",
                                            "Cryo Rounds,Rifle,5,1,IceDamage,0.15,D,6",
                                            "Deadly Sequence,Rifle,3,1,CritChance,0.5,V,4",
                                            "Deep Freeze,Pistol,5,1,IceDamage,0.15,D,6",
                                            "Disruptor,Shotgun,5,1,ImpactDamage,0.05,~,4",
                                            "Eagle Eye,Rifle,3,1,Zoom,0.0,~,4",
                                            "Entropy Burst,Rifle,3,1,FlatStatusBonus,0.05,V,4",
                                            "Erroding Blight,Pistol,3,1,MagCap,0.5,D,4",
                                            "Expel Corpus,Pistol,5,1,CorpusDamage,0.05,V,4",
                                            "Expel Grineer,Pistol,5,1,GrineerDamage,0.05,V,4",
                                            "Expel Infested,Pistol,5,1,InfestedDamage,0.05,V,4",
                                            "Fanged Fusillade,Rifle,5,1,SlashDamage,0.2,~,6",
                                            "Fast Hands,Rifle,5,1,ReladSpeed,0.05,~,2",
                                            "Firestorm,Rifle,3,1,MiscDamage,0.0,V,6",
                                            "Flechette,Shotgun,5,1,PunctureDamage,0.05,~,4",
                                            "Frail Momentum,Shotgun,5,2,FireRate,DamageBonus,0.15,-0.025,V,4",
                                            "Fridgid Blast,Shotgun,3,2,IceDamage,StatusChance,0.15,0.15,V,4",
                                            "Frostbite,Pistol,3,2,IceDamage,StatusChance,0.15,0.15,V,4",
                                            "Full Contact,Shotgun,5,1,ImpactDamage,0.2,~,6",
                                            "Gilded Truth,Rifle,3,1,FireRate,0.2,V,4",
                                            "Gunslinger,Pistol,5,1,FireRate,0.12,V,4",
                                            "Hammer Shot,Rifle,3,2,StatusChance,CritMultiplier,0.1,0.15,D,6",
                                            "Hawk Eye,Pistol,3,1,Zoom,0.0,~,4",
                                            "Heated Charge,Pistol,5,1,FireDamage,0.15,~,6",
                                            "Heavy Caliber,Rifle,10,2,DamageBonus,AccuracyBonus,0.15,-0.05,V,6",
                                            "Hell's Chamber,Shotgun,5,1,Multishot,0.2,V,10",
                                            "Hellfire,Rifle,5,1,FireDamage,0.15,~,6",
                                            "High Voltage,Rifle,3,2,LightningDamage,StatusChance,0.15,0.15,V,4",
                                            "Hollow Point,Pistol,5,2,CritMultiplier,DamageBonus,0.1,-0.025,~,4",
                                            "Hornet Strike,Pistol,10,1,DamageBonus,0.2,V,4",
                                            "Hush,Rifle,3,1,Silence,0.25,~,2",
                                            "Ice Storm,Pistol,3,2,MagCap,IceDamage,0.1,0.1,V,6",
                                            "Incendiary Coat,Shotgun,5,1,FireDamage,0.15,~,6",
                                            "Infected Clip,Rifle,5,1,ToxinDamage,0.15,~,6",
                                            "Jolt,Pistol,3,2,LightningDamage,StatusChance,0.15,0.15,V,4",
                                            "Lasting Purity,Rifle,3,1,DeadAim,0.15,~,4",
                                            "Lethal Torrent,Pistol,5,2,FireRate,Multishot,0.1,0.1,V,6",
                                            "Lingering Torment,Shotgun,5,1,StatusDuration,0.05,V,6",
                                            "Magazine Warp,Rifle,5,1,MagCap,0.05,~,4",
                                            "Magnum Force,Pistol,10,2,DamageBonus,AccuracyBonus,0.06,-0.03,V,4",
                                            "Maim,Pistol,5,1,SlashDamage,0.2,~,6",
                                            "Malignant Force,Rifle,3,2,ToxinDamage,StatusChance,0.15,0.15,V,4",
                                            "Metal Auger,Rifle,5,1,ObjectPierce,0.0,~,10",
                                            "No Return,Pistol,5,1,PunctureDamage,0.1,~,2",
                                            "Pathogen Rounds,Pistol,5,1,ToxinDamage,0.15,~,6",
                                            "Perpetual Agony,Pistol,5,1,StatusDuration,0.05,V,6",
                                            "Piercing Caliber,Rifle,5,1,PunctureDamage,0.2,~,6",
                                            "Piercing Hit,Rifle,5,1,PunctureDamage,0.05,~,4",
                                            "Pistol Gambit,Pistol,5,1,CritChance,0.2,V,4",
                                            "Pistol Mutation,Pistol,3,1,AmmoMutator,0.0,~,4",
                                            "Pistol Pestilence,Pistol,3,2,ToxinDamage,StatusChance,0.15,0.15,V,4",
                                            "Point Blank,Shotgun,5,1,DamageBonus,0.15,V,4",
                                            "Point Strike,Rifle,5,1,CritChance,0.25,V,4",
                                            "Primed Chamber,Rifle,3,1,FirstShotDamage,0.25,V,4",
                                            "Primed Fast Hands,Rifle,10,1,ReladSpeed,0.05,~,2",
                                            "Primed Heated Charge,Pistol,10,1,FireDamage,0.15,~,6",
                                            "Primed Pistol Gambit,Pistol,10,1,CritChance,0.17,V,2",
                                            "Primed Point Blank,Shotgun,10,1,DamageBonus,0.15,V,4",
                                            "Primed Ravage,Shotgun,10,1,CritMultiplier,0.1,V,4",
                                            "Quickdraw,Pistol,5,1,ReladSpeed,0.08,~,2",
                                            "Ravage,Shotgun,5,1,CritMultiplier,0.1,V,4",
                                            "Razor Shot,Pistol,5,1,SlashDamage,0.1,~,2",
                                            "Rifle Aptitude,Rifle,5,1,StatusChance,0.025,D,4",
                                            "Rifle Mutation,Rifle,3,1,AmmoMutator,0.0,~,4",
                                            "Rime Rounds,Rifle,3,2,IceDamage,StatusChance,0.15,0.15,V,4",
                                            "Rupture,Rifle,5,1,ImpactDamage,0.05,~,4",
                                            "Sawtooth Clip,Rifle,5,1,SlashDamage,0.05,~,4",
                                            "Scattered Justice,Shotgun,3,1,Multishot,0.5,V,4",
                                            "Scattering Inferno,Shotgun,3,2,FireDamage,StatusChance,0.15,0.15,V,4",
                                            "Scorch,Pistol,3,2,FireDamage,StatusChance,0.15,0.15,V,4",
                                            "Seeker,Pistol,5,1,ObjectPierce,0.0,~,10",
                                            "Seeking Force,Shotgun,5,1,ObjectPierce,0.0,~,10",
                                            "Seeking Fury,Shotgun,5,2,ObjectPierce,ReladSpeed,0.002,0.025,V,6",
                                            "Serration,Rifle,10,1,DamageBonus,0.15,V,4",
                                            "Shattering Justice,Shotgun,3,1,FlatStatusBonus,0.05,~,4",
                                            "Shell Compression,Shotgun,5,1,AmmoCap,0.05,~,2",
                                            "Shell Shock,Shotgun,3,2,LightningDamage,StatusChance,0.15,0.15,V,4",
                                            "Shotgun Mutation,Shotgun,3,1,AmmoMutator,0.0,~,4",
                                            "Shotgun Savvy,Shotgun,5,1,StatusChance,0.05,D,4",
                                            "Shotgun Spazz,Shotgun,5,1,FireRate,0.15,V,4",
                                            "Shred,Rifle,5,2,FireRate,ObjectPierce,0.05,0.0,V,6",
                                            "Shredder,Shotgun,5,1,SlashDamage,0.05,~,4",
                                            "Slip Magazine,Pistol,5,1,MagCap,0.05,~,4",
                                            "Sniper Mutation,Rifle,3,1,AmmoMutator,0.0,~,4",
                                            "Speed Trigger,Rifle,5,1,FireRate,0.1,V,4",
                                            "Split Chamber,Rifle,5,1,Multishot,0.15,V,10",
                                            "Stabilizer,Rifle,3,1,RecoilBonus,-0.15,~,6",
                                            "Steady hands,Pistol,3,1,RecoilBonus,-0.15,~,6",
                                            "Stinging Truth,Pistol,3,1,FlatMagBonus,0.1,D,4",
                                            "Stormbringer,Rifle,5,1,LightningDamage,0.15,~,6",
                                            "Stunning Speed,Pistol,3,2,StatusChance,ReladSpeed,0.025,0.1,~,6",
                                            "Suppress,Pistol,3,1,Silence,0.25,~,2",
                                            "Sure Shot,Pistol,5,1,StatusChance,0.025,D,2",
                                            "Sweeping Serration,Shotgun,5,1,SlashDamage,0.2,~,6",
                                            "Tactical Pump,Shotgun,5,1,ReladSpeed,0.05,~,2",
                                            "Tainted Clip,Pistol,5,2,MagCap,ReladSpeed,0.1,-0.05,~,6",
                                            "Tainted Mag,Rifle,10,2,MagCap,ReladSpeed,0.06,-0.03,~,4",
                                            "Tainted Shell,Shotgun,10,2,SpreadBonus,FireRate,-0.07,-0.06,D,4",
                                            "Target Cracker,Pistol,5,1,CritMultiplier,0.1,V,4",
                                            "Thermite Rounds,Rifle,3,2,FireDamage,StatusChance,0.15,0.15,V,4",
                                            "Thunderbolt,Rifle,0,1,FlatDamageBonus,2.0,V,9",
                                            "Toxic Barrage,Shotgun,3,2,ToxinDamage,StatusChance,0.15,0.15,V,4",
                                            "Toxic Sequence,Pistol,3,1,StatusDuration,0.5,D,4",
                                            "Trick Mag,Pistol,5,1,AmmoCap,0.15,~,2",
                                            "Vicious Spread,Shotgun,5,2,DamageBonus,SpreadBonus,0.15,0.1,V,4",
                                            "Vile Acceleration,Rifle,5,2,FireRate,DamageBonus,0.15,-0.025,V,4",
                                            "Vile Precision,Rifle,5,2,RecoilBonus,FireRate,-0.1,-0.06,~,6",
                                            "Vital Sense,Rifle,5,1,CritMultiplier,0.2,V,4",
                                            "Wildfire,Rifle,3,2,FireDamage,MagCap,0.15,0.05,V,6",
                                            "Automatic Trigger,ArcGun,5,1,FireRate,0.075,V,10",
                                            "Combustion Rounds,ArcGun,5,1,FireDamage,0.2,V,4",
                                            "Dual Rounds,ArcGun,5,1,Multishot,0.05,V,6",
                                            "Electrified Barrel,ArcGun,5,1,LightningDamage,0.2,~,4",
                                            "Hollowed Bullets,ArcGun,3,1,CritMultiplier,0.15,V,4",
                                            "Magazine Extension,ArcGun,5,1,MagCap,0.1,~,4",
                                            "Magma Chamber,ArcGun,3,2,FireDamage,StatusChance,0.15,0.15,V,4",
                                            "Modified Munitions,ArcGun,5,1,StatusChance,0.1,D,4",
                                            "Parallax Scope,ArcGun,3,1,CritChance,0.2,~,4",
                                            "Polar Magazine,ArcGun,5,1,IceDamage,0.2,D,4",
                                            "Rubedo-Lined Barrel,ArcGun,5,1,DamageBonus,0.1,V,6",
                                            "Venomous Clip,ArcGun,5,1,ToxinDamage,0.2,D,6",
                                            "Depleted Reload,Rifle,5,2,MagCap,ReladSpeed,-0.1,0.08,~,2",
  											"Primed Target Cracker,Pistol,10,1,CritMultiplier,0.1,V,4",
  											"Vigilante Armaments,Rifle,5,1,Multishot,0.1,~,4",
  											"Vigilante Armaments,Shotgun,5,1,Multishot,0.1,~,4",
  											"Primed Quickdraw,Pistol,10,1,ReladSpeed,0.08,~,2",
  											"Primed Slip Magazine,Pistol,10,1,MagCap,0.05,~,4",
  											"Auger Pact,Pistol,5,1,DamageBonus,0.15,V,2",
  											"Hydraulic Crosshairs,Pistol,5,1,CritChance,0.225,V,2",
  											"Argon Scope,Rifle,5,1,CritChance,0.225,V,2",
  											"Laser Sight,Shotgun,5,1,CritChance,0.2,V,4",
  											"Bladed Rounds,Rifle,5,1,CritMultiplier,0.2,V,4",
  											"Shrapnel Shot,Shotgun,5,1,CritMultiplier,0.165,V,4",
  											"Sharpened Bullets,Pistol,5,1,CritMultiplier,0.125,V,2",
  											"Hunter Munitions,Rifle,0,1,Munitions,1,V,9",
  											"Hunter Munitions,Shotgun,0,1,Munitions,1,V,9",
  											"Primed Shred,Rifle,10,2,FireRate,ObjectPierce,0.05,0.0,V,6",
  											"Primed Cryo Rounds,Rifle,10,1,IceDamage,0.15,D,6",
                                            "Primed Bane of Corpus,Rifle,10,1,CorpusDamage,0.05,V,4",
                                            "Primed Bane of Grineer,Rifle,10,1,GrineerDamage,0.05,V,4",
                                            "Primed Bane of Infested,Rifle,10,1,InfestedDamage,0.05,V,4",
  											"Chilling Reload,Shotgun,3,2,IceDamage,ReladSpeed,0.15,0.1,V,2"};
  
  public static final String[] maximizerModDB = {"Accelerated Blast,Shotgun,3,2,FireRate,PunctureDamage,0.15,0.15,V,6",
		  "Ammo Stock,Shotgun,5,1,MagCap,0.1,~,2",
		  "Anemic Agility,Pistol,5,2,FireRate,DamageBonus,0.15,-0.025,~,4",
		  "Argon Scope,Rifle,5,1,CritChance,0.225,V,2",
		  "Auger Pact,Pistol,5,1,DamageBonus,0.15,V,2",
		  "Automatic Trigger,ArcGun,5,1,FireRate,0.075,V,10",
		  "Barrel Diffusion,Pistol,5,1,Multishot,0.2,V,6",
		  "Bladed Rounds,Rifle,5,1,CritMultiplier,0.2,V,4",
		  "Blaze,Shotgun,3,2,DamageBonus,FireDamage,0.15,0.15,V,6",
		  "Blunderbuss,Shotgun,5,1,CritChance,0.15,V,4",
		  "Bore,Pistol,5,1,PunctureDamage,0.2,~,6",
		  "Breach Loader,Shotgun,5,1,PunctureDamage,0.2,~,6",
		  "Burdened Magazine,Shotgun,5,2,MagCap,ReladSpeed,0.1,-0.03,~,6",
          "Primed Charged Shell,Shotgun,10,1,LightningDamage,0.15,~,6",
		  "Chilling Grasp,Shotgun,5,1,IceDamage,0.15,D,6",
		  "Chilling Reload,Shotgun,3,2,IceDamage,ReladSpeed,0.15,0.1,V,2",
		  "Cleanse Corpus,Shotgun,5,1,CorpusDamage,0.05,V,4",
		  "Cleanse Grineer,Shotgun,5,1,GrineerDamage,0.05,V,4",
		  "Cleanse Infested,Shotgun,5,1,InfestedDamage,0.05,V,4",
		  "Combustion Rounds,ArcGun,5,1,FireDamage,0.2,V,4",
		  "Contagious Spread,Shotgun,5,1,ToxinDamage,0.15,~,6",
		  "Convulsion,Pistol,5,1,LightningDamage,0.15,~,6",
		  "Crash Course,Rifle,5,1,ImpactDamage,0.2,~,6",
		  "Deep Freeze,Pistol,5,1,IceDamage,0.15,D,6",
		  "Dual Rounds,ArcGun,5,1,Multishot,0.05,V,6",
		  "Electrified Barrel,ArcGun,5,1,LightningDamage,0.2,~,4",
		  "Expel Corpus,Pistol,5,1,CorpusDamage,0.05,V,4",
		  "Expel Grineer,Pistol,5,1,GrineerDamage,0.05,V,4",
		  "Expel Infested,Pistol,5,1,InfestedDamage,0.05,V,4",
		  "Fanged Fusillade,Rifle,5,1,SlashDamage,0.2,~,6",
		  "Frail Momentum,Shotgun,5,2,FireRate,DamageBonus,0.15,-0.025,V,4",
		  "Fridgid Blast,Shotgun,3,2,IceDamage,StatusChance,0.15,0.15,V,4",
		  "Frostbite,Pistol,3,2,IceDamage,StatusChance,0.15,0.15,V,4",
		  "Full Contact,Shotgun,5,1,ImpactDamage,0.2,~,6",
		  "Gunslinger,Pistol,5,1,FireRate,0.12,V,4",
		  "Hammer Shot,Rifle,3,2,StatusChance,CritMultiplier,0.1,0.15,D,6",
		  "Heavy Caliber,Rifle,10,2,DamageBonus,AccuracyBonus,0.15,-0.05,V,6",
		  "Hell's Chamber,Shotgun,5,1,Multishot,0.2,V,10",
		  "Hellfire,Rifle,5,1,FireDamage,0.15,~,6",
		  "High Voltage,Rifle,3,2,LightningDamage,StatusChance,0.15,0.15,V,4",
		  "Hollowed Bullets,ArcGun,3,1,CritMultiplier,0.15,V,4",
		  "Hornet Strike,Pistol,10,1,DamageBonus,0.2,V,4",
		  "Hunter Munitions,Rifle,0,1,Munitions,1.0,V,9",
		  "Hunter Munitions,Shotgun,0,1,Munitions,1.0,V,9",
		  "Hydraulic Crosshairs,Pistol,5,1,CritChance,0.225,V,2",
		  "Ice Storm,Pistol,3,2,MagCap,IceDamage,0.1,0.1,V,6",
		  "Incendiary Coat,Shotgun,5,1,FireDamage,0.15,~,6",
		  "Infected Clip,Rifle,5,1,ToxinDamage,0.15,~,6",
		  "Jolt,Pistol,3,2,LightningDamage,StatusChance,0.15,0.15,V,4",
		  "Laser Sight,Shotgun,5,1,CritChance,0.2,V,4",
		  "Lethal Torrent,Pistol,5,2,FireRate,Multishot,0.1,0.1,V,6",
		  "Magazine Extension,ArcGun,5,1,MagCap,0.1,~,4",
		  "Magazine Warp,Rifle,5,1,MagCap,0.05,~,4",
		  "Magma Chamber,ArcGun,3,2,FireDamage,StatusChance,0.15,0.15,V,4",
		  "Maim,Pistol,5,1,SlashDamage,0.2,~,6",
		  "Malignant Force,Rifle,3,2,ToxinDamage,StatusChance,0.15,0.15,V,4",
		  "Modified Munitions,ArcGun,5,1,StatusChance,0.1,D,4",
		  "Parallax Scope,ArcGun,3,1,CritChance,0.2,~,4",
		  "Pathogen Rounds,Pistol,5,1,ToxinDamage,0.15,~,6",
		  "Piercing Caliber,Rifle,5,1,PunctureDamage,0.2,~,6",
		  "Pistol Pestilence,Pistol,3,2,ToxinDamage,StatusChance,0.15,0.15,V,4",
		  "Point Strike,Rifle,5,1,CritChance,0.25,V,4",
		  "Polar Magazine,ArcGun,5,1,IceDamage,0.2,D,4",
          "Primed Bane of Corpus,Rifle,10,1,CorpusDamage,0.05,V,4",
          "Primed Bane of Grineer,Rifle,10,1,GrineerDamage,0.05,V,4",
          "Primed Bane of Infested,Rifle,10,1,InfestedDamage,0.05,V,4",
		  "Primed Cryo Rounds,Rifle,10,1,IceDamage,0.15,D,6",
		  "Primed Fast Hands,Rifle,10,1,ReladSpeed,0.05,~,2",
		  "Primed Heated Charge,Pistol,10,1,FireDamage,0.15,~,6",
		  "Primed Pistol Gambit,Pistol,10,1,CritChance,0.17,V,2",
		  "Primed Point Blank,Shotgun,10,1,DamageBonus,0.15,V,4",
		  "Primed Quickdraw,Pistol,10,1,ReladSpeed,0.08,~,2",
		  "Primed Ravage,Shotgun,10,1,CritMultiplier,0.1,V,4",
		  "Primed Shred,Rifle,10,2,FireRate,ObjectPierce,0.05,0.0,V,6",
		  "Primed Slip Magazine,Pistol,10,1,MagCap,0.05,~,4",
		  "Primed Target Cracker,Pistol,10,1,CritMultiplier,0.1,V,4",
		  "Rime Rounds,Rifle,3,2,IceDamage,StatusChance,0.15,0.15,V,4",
		  "Rubedo-Lined Barrel,ArcGun,5,1,DamageBonus,0.1,V,6",
		  "Scattering Inferno,Shotgun,3,2,FireDamage,StatusChance,0.15,0.15,V,4",
		  "Scorch,Pistol,3,2,FireDamage,StatusChance,0.15,0.15,V,4",
		  "Seeking Fury,Shotgun,5,2,ObjectPierce,ReladSpeed,0.002,0.025,V,6",
		  "Serration,Rifle,10,1,DamageBonus,0.15,V,4",
		  "Sharpened Bullets,Pistol,5,1,CritMultiplier,0.125,V,2",
		  "Shell Shock,Shotgun,3,2,LightningDamage,StatusChance,0.15,0.15,V,4",
		  "Shotgun Spazz,Shotgun,5,1,FireRate,0.15,V,4",
		  "Shrapnel Shot,Shotgun,5,1,CritMultiplier,0.165,V,4",
		  "Speed Trigger,Rifle,5,1,FireRate,0.1,V,4",
		  "Split Chamber,Rifle,5,1,Multishot,0.15,V,10",
		  "Stormbringer,Rifle,5,1,LightningDamage,0.15,~,6",
		  "Sweeping Serration,Shotgun,5,1,SlashDamage,0.2,~,6",
		  "Tactical Pump,Shotgun,5,1,ReladSpeed,0.05,~,2",
		  "Tainted Mag,Rifle,10,2,MagCap,ReladSpeed,0.06,-0.03,~,4",
		  "Thermite Rounds,Rifle,3,2,FireDamage,StatusChance,0.15,0.15,V,4",
		  "Toxic Barrage,Shotgun,3,2,ToxinDamage,StatusChance,0.15,0.15,V,4",
		  "Venomous Clip,ArcGun,5,1,ToxinDamage,0.2,D,6",
		  "Vicious Spread,Shotgun,5,2,DamageBonus,SpreadBonus,0.15,0.1,V,4",
		  "Vigilante Armaments,Rifle,5,1,Multishot,0.1,~,4",
		  "Vigilante Armaments,Shotgun,5,1,Multishot,0.1,~,4",
		  "Vile Acceleration,Rifle,5,2,FireRate,DamageBonus,0.15,-0.025,V,4",
		  "Vital Sense,Rifle,5,1,CritMultiplier,0.2,V,4",
		  "Wildfire,Rifle,3,2,FireDamage,MagCap,0.15,0.05,V,6"};
  
  /** Default Weapons for use if the file is missing **/
  public static final String[] baseWeapons = {"Pistol,Semi-Auto,Toxin,Acrid,0.0,0,DEPRECIATED,35,0.0,0.0,0.0,6.67,15,210,1.2,5,2,10,1,1",
		  "Pistol,Full-Auto,Physical,Afuris,0.0,0,DEPRECIATED,0.0,3,14,3,12.5,70,210,2,5,2,12,1,1",
		  "Pistol,Burst,Physical,AkJagara,0.0,2,DEPRECIATED,0.0,4.5,4.5,21,8.33,36,210,2.25,6,2,28,1,1",
		  "Pistol,Full-Auto,Physical,AkZani,0.0,0,DEPRECIATED,0.0,1.8,8.4,1.8,20,100,400,2,14,2,14,1,1",
		  "Pistol,Semi-Auto,Physical,Akbolto,0.0,0,DEPRECIATED,0.0,4,36,0,10,30,210,2.6,16,2.4,2.2,1,1",
		  "Pistol,Semi-Auto,Physical,Akbolto Prime,0.0,0,DEPRECIATED,0.0,3.2,27.5,1.3,7,40,210,1.3,36,2.8,14,1,1",
		  "Pistol,Semi-Auto,Physical,Akbronco,0.0,0,DEPRECIATED,0.0,224,28,28,8.33,4,210,2.25,6,2,22,7,1",
		  "Pistol,Semi-Auto,Physical,Akbronco Prime,0.0,0,DEPRECIATED,0.0,280,35,35,4.33,8,210,2.25,6,2,30,7,1",
		  "Pistol,Semi-Auto,Physical,Aklato,0.0,0,DEPRECIATED,0.0,4.5,7.5,18,7.5,30,210,2.4,10,1.8,6,1,1",
		  "Pistol,Semi-Auto,Physical,Aklex,0.0,0,DEPRECIATED,0.0,13,104,13,1.58,12,210,3,20,2,10,1,1",
		  "Pistol,Semi-Auto,Physical,Aklex Prime,0.0,0,DEPRECIATED,0.0,15,120,15,2.67,16,210,3,25,2,25,1,1",
		  "Pistol,Semi-Auto,Physical,Akmagnus,0.0,0,DEPRECIATED,0.0,34.2,20.9,20.9,6.17,16,210,2.4,22,2,22,1,1",
		  "Pistol,Full-Auto (Ramp-up),Physical,Aksomati,0.0,0,DEPRECIATED,0.0,1.8,7.2,9,12.5,70,210,1.4,24,3,8,1,1",
		  "Pistol,Full-Auto,Physical,Akstiletto,0.0,0,DEPRECIATED,0.0,16.8,2.8,8.4,10,28,210,1.1,18,1.8,18,1,1",
		  "Pistol,Full-Auto,Physical,Akstiletto Prime,0.0,0,DEPRECIATED,0.0,21.6,3.6,10.8,7.08,40,400,1.1,15,2,30,1,1",
		  "Pistol,Semi-Auto,Physical,Akvasto,0,0,DEPRECIATED,0,14.5,14.5,29,8.67,12,210,2,16,1.8,12,1,1",
		  "Rifle,Continuous,Electric,Amprex,0.0,0,DEPRECIATED,22,0.0,0.0,0.0,12.5,100,700,2.6,32,2.2,22,1,0.5",
		  "Pistol,Charge,Blast,Angstrum (Charged),1.5,0,DEPRECIATED,750,0.0,0.0,0.0,2,1,6,2.5,16,2,52.5,3,1",
		  "Pistol,Semi-Auto,Blast,Angstrum (Single Rocket),0.0,0,DEPRECIATED,250,0.0,0.0,0.0,2,3,18,2.5,16,2,22,1,1",
		  "Shotgun,Semi-Auto,Radiation,Arca Plasmor,0,0,DEPRECIATED,600,0,0,0,1.1,10,48,2.8,22,1.6,28,1,1",
		  "Pistol,Semi-Auto,Physical,Arca Scisco,0,0,DEPRECIATED,0,0,36,24,4.67,36,288,2.2,18,1.6,26,1,1",
		  "Rifle,Full-Auto,Physical,Argonak (Full-auto),0.0,0,DEPRECIATED,0.0,24.5,6.3,26.2,6,43,540,2.4,9,1.5,27,1,1",
		  "Rifle,Semi-Auto,Physical,Argonak (Semi-auto),0.0,0,DEPRECIATED,0.0,24.5,6.3,26.2,4.33,43,473,2.4,27,2.3,19,1,1",
		  "Shotgun,Full-Auto,Physical,Astilla,0,0,DEPRECIATED,190,70.3,41.8,77.9,4.33,16,112,2,17,1.9,33,1,1",
		  "Pistol,Continuous,Fire,Atomos,0,0,DEPRECIATED,29,0,0,0,8,70,300,2,15,1.7,21,1,1",
		  "Rifle,Full-Auto,Physical,Attica,0,0,DEPRECIATED,0,4,60,16,3.67,20,540,2.8,25,3,10,1,1",
		  "Pistol,Full-Auto,Physical,Azima,0,0,DEPRECIATED,0,2,5,13,10,75,525,1.4,16,2,16,1,1",
		  "Pistol,Burst,Physical,Ballistica (Burst),1,4,DEPRECIATED,0,2.5,20,2.5,11.43,16,210,2,3.75,1.5,2.5,1,1",
		  "Pistol,Charge,Physical,Ballistica (Charge),1,4,DEPRECIATED,0,10,80,10,3.33,16,210,2,15,1.5,10,1,1",
		  "Pistol,Charge,Physical,Ballistica Prime (Charge),0.8,0,DEPRECIATED,0,15,167.2,121.6,3.33,8,210,1.2,20,2,20,4,1",
		  "Pistol,Semi-Auto,Physical,Ballistica Prime (Normal),0,0,DEPRECIATED,0,7.6,83.6,60.8,3.33,8,210,1.2,20,2,20,4,1",
		  "Rifle,Full-Auto,Physical,Baza,0.0,0,DEPRECIATED,0.0,5.8,6.7,3.5,16.67,40,800,1.4,26,3,10,1,1",
		  "Shotgun,Full-Auto,Physical,Boar,0.0,0,DEPRECIATED,0.0,96.8,26.4,52.8,5,20,120,2.7,10,1.5,20,8,1",
		  "Shotgun,Full-Auto,Physical,Boar Prime,0.0,0,DEPRECIATED,0.0,208,48,64,4.67,20,120,2.75,15,2,30,8,1",
		  "Pistol,Semi-Auto,Physical,Bolto,0,0,DEPRECIATED,0,4,36,0,6.83,15,210,1.3,16,2.4,2.2,1,1",
		  "Rifle,Full-Auto,Physical,Boltor,0.0,0,DEPRECIATED,0.0,2.5,20.0,2.5,8.75,60,540,2.6,10,1.8,14,1,1",
		  "Rifle,Full-Auto,Physical,Boltor Prime,0.0,0,DEPRECIATED,0.0,4.6,41.4,0,10,60,540,2.4,12,2,34,1,1",
		  "Pistol,Semi-Auto,Physical,Brakk,0,0,DEPRECIATED,0,90,50,60,5,5,210,1.05,17,2,17,10,1",
		  "Rifle,Full-Auto,Physical,Braton,0.0,0,DEPRECIATED,0.0,7.9,7.9,8.2,8.75,45,540,2,12,1.6,6,1,1",
		  "Rifle,Full-Auto,Physical,Braton Prime,0.0,0,DEPRECIATED,0.0,1.75,12.25,21,9.58,75,540,2.15,12,2,26,1,1",
		  "Rifle,Full-Auto,Physical,Braton Vandal,0.0,0,DEPRECIATED,0.0,12.25,1.75,21,7.5,50,540,1.75,16,2,10,1,1",
		  "Pistol,Semi-Auto,Physical,Bronco,0,0,DEPRECIATED,0,224,28,28,5,2,210,1.05,6,2,22,7,1",
		  "Pistol,Semi-Auto,Physical,Bronco Prime,0,0,DEPRECIATED,0,280,35,35,4.17,4,210,2,6,2,30,7,1",
		  "Rifle,Burst,Physical,Burston,0.0,3,DEPRECIATED,0.0,10,10,10,7.83,45,540,2,6,1.6,18,1,1",
		  "Rifle,Burst,Physical,Burston Prime,0.0,3,DEPRECIATED,0.0,10.8,10.8,14.4,13.64,45,540,2,18,1.8,30,1,1",
		  "Rifle,Full-Auto,Physical,Buzlok,0.0,0,DEPRECIATED,0.0,30,24,6,6.25,50,540,3,23,2.5,21,1,1",
		  "Pistol,Semi-Auto,Electric,Castanas,0.0,0,DEPRECIATED,160,0,0,0,3.33,2,18,1,8,1.5,22,1,1",
		  "Rifle,Charge,Physical,Cernos,0.5,0,DEPRECIATED,0,198,11,11,1,1,72,0.6,36,2,18,1,1",
		  "Rifle,Charge,Physical,Cernos (Charged),1,3,6.7,300,180,10,10,1,1,72,0.6,35,2,10,1,1",
		  "Rifle,Charge,Physical,Cernos Prime,0.5,0,DEPRECIATED,0,324,18,18,1,1,72,0.65,35,2,30,3,1",
		  "Pistol,Full-Auto (Ramp-up),Physical,Cestra,0,0,DEPRECIATED,0,5.2,20.8,0,8.33,60,420,2,6,1.6,20,1,1",
		  "Shotgun,Continuous,Physical,Convectrix,0.0,0,DEPRECIATED,0.0,2.4,2.4,19.2,12,70,700,2,16,2.4,30,2,0.5",
		  "Shotgun,Semi-Auto,Physical,Corinth,0.0,0,DEPRECIATED,0.0,151.2,226.8,162,1.17,5,132,2.3,30,2.8,12,6,1",
		  "Rifle,Charge,Physical,Daikyu,1,0,DEPRECIATED,0,138,184,138,1,1,72,0.6,20,2,50,1,1",
		  "Rifle,Full-Auto,Physical,Dera,0.0,0,DEPRECIATED,0.0,6,22.5,1.5,11.25,45,540,1.8,8,1.6,22,1,1",
		  "Rifle,Full-Auto,Physical,Dera Vandal,0.0,0,DEPRECIATED,0.0,6.4,24,1.6,11.25,60,540,1.8,8,2,30,1,1",
		  "Pistol,Full-Auto,Physical,Despair,0.0,0,DEPRECIATED,0,2.9,46.4,8.7,3.33,10,210,0.75,16,1.6,16,1,1",
		  "Pistol,Semi-Auto,Radiation,Detron,0,0,DEPRECIATED,280,0,0,0,3.33,5,210,1.05,4,1.5,30,7,1",
		  "Pistol,Full-Auto,Physical,Dex Furis,0.0,0,DEPRECIATED,0.0,2.4,11.2,2.4,20,100,400,2,14,2,28,1,1",
		  "Rifle,Burst,Physical,Dex Sybaris,0.0,2,DEPRECIATED,0,22.5,18.75,33.75,4.17,14,540,1.5,35,2,10,1,1",
		  "Shotgun,Charge,Physical,Drakgoon,0.5,0,DEPRECIATED,0.0,70,70,560,3.33,7,120,2.3,7.5,2,23,10,1",
		  "Shotgun,Charge,Physical,Drakgoon (Charge),1,0,,0.0,90,90,720,3.33,7,120,2.3,7.5,2,10,10,1",
		  "Rifle,Charge,Physical,Dread,0.5,0,DEPRECIATED,0,10,10,180,1,1,72,0.7,50,2,20,1,1",
		  "Rifle,Charge,Physical,Dread (Charged),1,3,6.7,300,10,10,180,1,1,72,0.7,50,2,20,1,1",
		  "Pistol,Full-Auto (Ramp-up),Physical,Dual Cestra,0.0,0,DEPRECIATED,0.0,5.2,20.8,0,12.5,120,210,3.5,6,1.6,20,1,1",
		  "Pistol,Semi-Auto,Physical,Dual Toxocyst,0.0,0,DEPRECIATED,0.0,7.5,60,7.5,1,12,72,2.35,5,2,37,1,1",
		  "Pistol,Continuous,Toxin,Embolist,0,0,DEPRECIATED,35,0,0,0,8,33,210,1.3,3,1.5,41,1,0.5",
		  "Pistol,Semi-Auto,Physical,Euphona Prime (Primary),0.0,0,DEPRECIATED,0.0,292.5,16.25,16.25,1.5,5,210,2,30,2.5,2,1,1",
		  "Pistol,Semi-Auto,Physical,Euphona Prime (Secondary),0.0,0,DEPRECIATED,0.0,44,176,660,1.5,5,210,2,2,2,30,10,1",
		  "Rifle,Charge,Physical,Ferrox,0.5,0,DEPRECIATED,0.0,35,245,70,1.33,10,540,2,32,2.8,10,1,1",
		  "Rifle,Continuous,Physical,Flux Rifle,0.0,0,DEPRECIATED,25,0,4.8,17.2,12,50,9999,2.25,10,2,24,1,0.5",
		  "Pistol,Full-Auto,Physical,Furis,0,0,DEPRECIATED,0,3,14,3,10,35,210,1.4,5,2,12,1,1",
		  "Pistol,Full-Auto,Physical,Fusilai (Full-Auto),0.0,0,DEPRECIATED,77,0,30.8,46.2,2.83,6,72,0.8,23,1.7,29,1,1",
		  "Pistol,Continuous,Magnetic,Gammacor,0,0,DEPRECIATED,16,0,0,0,12,60,210,1.4,8,1.8,20,1,0.5",
		  "Rifle,Continuous,Ice,Glaxion,0,0,DEPRECIATED,26,0,0,0,12,80,720,2.2,8,2,34,1,0.5",
		  "Rifle,Full-Auto (Ramp-up),Physical,Gorgon,0.0,0,DEPRECIATED,0.0,18.75,3.75,2.5,12.5,90,540,4.2,17,1.5,9,1,1",
		  "Rifle,Full-Auto (Ramp-up),Physical,Gorgon Wraith,0.0,0,DEPRECIATED,0.0,23,2.7,1.3,13.3,90,540,3,15,1.9,21,1,1",
		  "Rifle,Full-Auto,Physical,Grakata,0.0,0,DEPRECIATED,0.0,4.4,3.7,2.9,20,60,750,2.4,25,2,20,1,1",
		  "Rifle,Semi-Auto,Physical,Grinlok,0.0,0,DEPRECIATED,0.0,93.5,18.7,74.8,1.67,9,540,1.7,15,2.5,35,1,1",
		  "Rifle,Burst,Physical,Harpak,0,3,DEPRECIATED,0,5,37.5,7.5,6,45,540,2,20,2.3,17,1,1",
		  "Shotgun,Semi-Auto,Physical,Hek,0.0,0,DEPRECIATED,0.0,78.75,341.25,105,2.17,4,120,2,10,2,25,7,1",
		  "Rifle,Burst,Viral,Hema,0.0,3,DEPRECIATED,47,0,0,0,6,60,999,2,11,2,25,1,1",
		  "Pistol,Full-Auto,Physical,Hikou,0.0,0,DEPRECIATED,0,2.6,15.6,7.8,6.67,20,210,0.75,4,1.6,10,1,1",
		  "Pistol,Full-Auto,Physical,Hikou Prime,0.0,0,DEPRECIATED,0,3.6,30.6,1.8,5.83,26,210,0.5,6,1.8,15,1,1",
		  "Rifle,Burst,Physical,Hind,,5,14,,7.5,7.5,15,5,65,470,2,5,1.5,10,1,1",
		  "Rifle,Burst,Physical,Hind (Burst),0.0,5,DEPRECIATED,0.0,7.5,7.5,15,6.25,65,540,2,7,1.5,15,1,1",
		  "Rifle,Semi-Auto,Physical,Hind (Semi-Auto),0.0,0,DEPRECIATED,0.0,12,12,36,2.5,65,540,2,15,2,10,1,1",
		  "Pistol,Full-Auto,Physical,Hystrix (Poison),0,0,DEPRECIATED,0,2.2,31,2.9,7,16,210,1.7,24,2.2,10,1,1",
		  "Rifle,Continuous,Fire,Ignis,0.0,0,DEPRECIATED,33,0,0,0,8,150,750,2,11,2,27,1,1",
		  "Rifle,Continuous,Fire,Ignis Wraith,0.0,0,DEPRECIATED,35,0,0,0,8,200,800,1.7,17,2.5,29,1,1",
		  "Rifle,Charge,Fire,Javlok,0.3,0,DEPRECIATED,280,0,0,0,3.33,6,300,0.6,20,2,25,1,1",
		  "Rifle,Full-Auto,Physical,Karak,0.0,0,DEPRECIATED,0.0,13,8.7,7.3,11.67,30,540,2,9,1.5,15,1,1",
		  "Rifle,Full-Auto,Physical,Karak Wraith,0.0,0,DEPRECIATED,0.0,14.1,9.3,7.8,11.67,60,540,2,13,2,25,1,1",
		  "Pistol,Semi-Auto,Physical,Knell,0.0,0,DEPRECIATED,150,63,69,18,4,9999,9999,1,20,2.214,65,1,1",
		  "Shotgun,Full-Auto (Bullet-Ramp),Physical,Kohm,0.0,0,DEPRECIATED,0.0,72,72,216,3.67,245,960,2,11,2.3,25,12,1",
		  "Pistol,Full-Auto (Bullet-Ramp),Physical,Kohmak,0.0,0,DEPRECIATED,0.0,30,30,90,5,40,210,2,11,2,23,5,1",
		  "Pistol,Burst,Physical,Kraken,0,2,DEPRECIATED,0,36.8,6.1,6.1,4.42,14,210,2.45,5,2,13,1,1",
		  "Pistol,Semi-Auto,Blast,Kulstar (With Bombs),0,0,DEPRECIATED,525,0,0,0,2,3,15,2,17,2.3,19,1,1",
		  "Pistol,Full-Auto,Physical,Kunai,0.0,0,DEPRECIATED,0,4.6,34.5,6.9,3.33,10,210,0.8,8,1.6,8,1,1",
		  "Rifle,Charge,Electric,Lanka,1,0,DEPRECIATED,525,0,0,0,1,10,72,2,25,2,25,1,1",
		  "Pistol,Semi-Auto,Physical,Lato,0,0,DEPRECIATED,0,7.5,7.5,15,6.67,15,210,1,10,1.8,6,1,1",
		  "Pistol,Semi-Auto,Physical,Lato Prime,0.0,0,DEPRECIATED,0.0,4.8,9.6,33.6,6.67,20,210,1,30,2,20,1,1",
		  "Pistol,Semi-Auto,Physical,Lato Vandal,0.0,0,DEPRECIATED,0.0,6.9,11.5,27.6,5,15,210,1,26,2.4,10,1,1",
		  "Rifle,Semi-Auto,Physical,Latron,0.0,0,DEPRECIATED,0.0,8.25,38.5,8.25,4.17,15,540,2.4,12,2,12,1,1",
		  "Rifle,Semi-Auto,Physical,Latron Prime,0.0,5,DEPRECIATED,0.0,9,72,9,4.2,15,540,2.4,22,2.8,26,1,1",
		  "Rifle,Semi-Auto,Physical,Latron Wraith,0.0,0,DEPRECIATED,0.0,15,42,3,5.42,15,540,2.4,26,2.8,14,1,1",
		  "Rifle,Charge,Blast,Lenz,1.2,0,DEPRECIATED,660,0,0,0,1,1,6,0.6,50,2,5,1,1",
		  "Pistol,Semi-Auto,Physical,Lex,0,0,DEPRECIATED,0,13,104,13,1.08,6,210,2.35,20,2,10,1,1",
		  "Pistol,Semi-Auto,Physical,Lex Prime,0.0,0,DEPRECIATED,0.0,15,120,15,2.08,8,210,2.35,25,2,25,1,1",
		  "Pistol,Full-Auto,Physical,MK-1 Furis,1,4,DEPRECIATED,0,1.95,9.1,1.95,8.33,35,210,1.4,5,2,1,1,1",
		  "Shotgun,Semi-Auto,Physical,MK-1 Strun,0.0,0,DEPRECIATED,0.0,99,27,54,2.08,6,120,3.75,7.5,1.5,20,10,1",
		  "Rifle,Full-Auto,Physical,MK1-Braton,0.0,0,DEPRECIATED,0.0,4.5,4.5,9,7.5,60,540,2.0,8,1.5,5,1,1",
		  "Pistol,Full-Auto,Physical,MK1-Kunai,0.0,0,DEPRECIATED,0,4,30,6,3.33,10,210,0.75,5,2,2.5,1,1",
		  "Rifle,Charge,Physical,MK1-Paris,0.5,0,DEPRECIATED,0,6,96,18,1,1,72,0.55,30,2,15,1,1",
		  "Pistol,Semi-Auto,Physical,Magnus,1,2,DEPRECIATED,0,34.2,20.9,20.9,5.83,8,210,1.4,22,2,22,1,1",
		  "Pistol,Semi-Auto,Radiation,Mara Detron,0,0,DEPRECIATED,280,0,0,0,3.33,8,210,1.05,8,1.5,32,7,1",
		  "Pistol,Semi-Auto,Physical,Marelok,0,0,DEPRECIATED,0,80,16,64,2,6,210,1.67,15,1.5,30,1,1",
		  "Rifle,Charge,Physical,Miter,0.75,0,DEPRECIATED,0,12.5,12.5,225,2.5,20,72,2,10,2,50,1,1",
		  "Rifle,Charge,Physical,Mutalist Cernos,0.5,0,DEPRECIATED,0,202.5,11.25,11.25,1,1,72,0.6,15,2,49,1,1",
		  "Rifle,Full-Auto,Physical,Mutalist Quanta,0.0,0,DEPRECIATED,0.0,2.5,15,7.5,10,60,540,3,2.5,1.5,15,1,1",
		  "Rifle,Semi-Auto,Radiation,Mutalist Quanta Cubes,2.5,5,14,200,0,0,0,1,4,31,2,15,2,15,1,1",
		  "Pistol,Continuous,Radiation,Nukor,0,0,DEPRECIATED,22,0,0,0,10,50,210,2,3,4,29,1,0.5",
		  "Rifle,Charge,Blast,Ogris,0.3,0,DEPRECIATED,600,0,0,0,1.5,5,20,2.5,5,2,35,1,1",
		  "Rifle,Charge,Physical,Opticor,2,0,DEPRECIATED,0.0,100,850,50,1,5,200,2,20,2.5,20,1,1",
		  "Pistol,Semi-Auto,Physical,Pandero,0.0,0,DEPRECIATED,72,18,18,36,3,8,210,1,30,2.8,10,1,1",
		  "Rifle,Full-Auto,Physical,Panthera,0,0,DEPRECIATED,0,20,10,70,3,60,540,2,12,2,24,1,1",
		  "Rifle,Continuous,Physical,Panthera (Secondary Attack),0,0,DEPRECIATED,0,10,10,80,2,60,540,2,25,2,35,1,1",
		  "Rifle,Burst,Toxin,Paracyst,0.0,0,DEPRECIATED,33,0,0,0,11.11,60,540,2,10,2,30,1,1",
		  "Rifle,Charge,Physical,Paris,0.5,0,DEPRECIATED,0,9,144,27,1,1,72,0.65,30,2,10,1,1",
		  "Rifle,Charge,Physical,Paris Prime,0.5,0,DEPRECIATED,0,6.5,208,45.5,1,1,72,0.7,45,2,20,1,1",
		  "Rifle,Semi-Auto,Blast,Penta,0,0,DEPRECIATED,350,0,0,0,1,5,20,2.5,10,2,10,1,1",
		  "Shotgun,Continuous,Viral,Phage,0,0,DEPRECIATED,30,0,0,0,12,90,720,2,19,2,31,7,0.5",
		  "Pistol,Full-Auto,Toxin,Pox (Poison Cloud),0.0,0,DEPRECIATED,100,0,0,0,2.08,4,20,1,1,2,35,1,1",
		  "Pistol,Charge,Blast,Prisma Angstrum (Charged),0.6,0,DEPRECIATED,750,0.0,0.0,0.0,2,1,6,1.8,18,2.2,59.5,3,1",
		  "Pistol,Semi-Auto,Blast,Prisma Angstrum (Single Rocket),0.0,0,DEPRECIATED,250,0.0,0.0,0.0,2,3,18,2,18,2.2,26,1,1",
		  "Pistol,Full-Auto,Physical,Prisma Twin Gremlins,0.0,0,DEPRECIATED,0.0,3,12.7,11.3,8.83,70,600,0.9,23,1.9,23,1,1",
		  "Rifle,Full-Auto (Ramp-up),Physical,Prisma Gorgon,0.0,0,DEPRECIATED,0.0,17.3,3.5,2.3,14.17,120,840,3,30,2.3,15,1,1",
		  "Rifle,Full-Auto,Physical,Prisma Grakata,0.0,0,DEPRECIATED,0.0,6,5,4,21.67,120,1000,2,25,2.5,21,1,1",
		  "Rifle,Full-Auto,Physical,Prisma Tetra,0.0,0,DEPRECIATED,0,7.6,30.4,0,7.08,60,540,2,10,2,24,1,1",
		  "Pistol,Semi-Auto,Physical,Pyrana,0.0,0,DEPRECIATED,0.0,26.4,26.4,211.2,4.17,10,210,2,20,2,10,12,1",
		  "Pistol,Semi-Auto,Physical,Pyrana Prime,0.0,0,DEPRECIATED,0.0,19.2,19.2,201.6,6.1,12,210,1.6,24,2.4,12,12,1",
		  "Rifle,Continuous,Electric,Quanta,0.0,0,DEPRECIATED,20,0,0,0,12,60,540,2,16,2.2,16,1,0.5",
		  "Rifle,Semi-Auto,Blast,Quanta (Cubes),0.0,0,DEPRECIATED,250,0,0,0,12,6,540,2,16,2.2,16,1,1",
		  "Rifle,Continuous,Electric,Quanta Vandal,0.0,0,DEPRECIATED,26,0,0,0,12,80,560,1.8,22,2.4,30,1,0.5",
		  "Rifle,Semi-Auto,Blast,Quanta Vandal (Cubes),0.0,0,DEPRECIATED,250,0,0,0,4,8,56,1.8,5,1.5,26,1,1",
		  "Rifle,Burst,Physical,Quartakk,0.0,4,DEPRECIATED,0.0,18.1,14.2,16.7,6.33,84,540,1.9,19,2.3,27,1,1",
		  "Pistol,Burst,Physical,Rakta Ballistica (Burst),1,4,DEPRECIATED,0,3.75,67.5,3.75,11.43,20,210,2,5,1.5,2.5,1,1",
		  "Pistol,Charge,Physical,Rakta Ballistica (Charge),1,4,DEPRECIATED,0,15,270,15,3.33,20,210,2,20,1.5,10,1,1",
		  "Rifle,Charge,Physical,Rakta Cernos,0.25,0,DEPRECIATED,0,225,12.5,12.5,1,1,72,0.6,35,2,15,1,1",
		  "Rifle,Semi-Auto,Physical,Rubico,0,0,DEPRECIATED,0,144,27,9,2.67,5,72,2.4,30,3,12,1,1",
		  "Rifle,Semi-Auto,Physical,Rubico Prime,0,0,DEPRECIATED,0,149.6,28.1,9.3,3.67,5,72,2,38,3,16,1,1",
		  "Pistol,Semi-Auto,Electric,Sancti Castanas,0.0,0,DEPRECIATED,300,0,0,0,3.33,2,18,1,24,2,34,1,1",
		  "Shotgun,Burst,Physical,Sancti Tigris,0.0,2,DEPRECIATED,0.0,126,126,1008,2,2,120,1.5,15,1.5,28,6,1",
		  "Rifle,Full-Auto,Corrosive,Scourge,0,0,DEPRECIATED,100,0,0,0,2.67,20,100,0.6,2,1.5,30,1,1",
		  "Pistol,Full-Auto (Ramp-up),Physical,Secura Dual Cestra,0.0,0,DEPRECIATED,0.0,5.6,22.4,0,12.5,120,480,3.5,16,1.6,28,1,1",
		  "Rifle,Semi-Auto,Blast,Secura Penta,0,0,DEPRECIATED,300,0,0,0,2,7,28,2.5,26,2,26,1,1",
		  "Pistol,Semi-Auto,Physical,Seer,0,0,DEPRECIATED,0,33.67,33.67,33.67,2,8,210,2.8,5,1.5,13,1,1",
		  "Pistol,Burst,Physical,Sicarus,1,3,DEPRECIATED,0,21,4.5,4.5,7.39,15,210,2,16,2,6,1,1",
		  "Pistol,Burst,Physical,Sicarus Prime,1,3,DEPRECIATED,50,20,15,15,9.38,24,210,2,25,2,20,1,1",
		  "Rifle,Semi-Auto,Physical,Snipetron,0,0,DEPRECIATED,300,18,144,18,2,4,72,3.5,30,1.5,12,1,1",
		  "Rifle,Semi-Auto,Physical,Snipetron Vandal,0,0,DEPRECIATED,0,10,180,10,2,6,72,2,28,2,16,1,1",
		  "Shotgun,Full-Auto,Physical,Sobek,0.0,0,DEPRECIATED,0.0,262.5,43.75,43.75,2.5,20,240,2.7,11,2,27,5,1",
		  "Rifle,Full-Auto (Ramp-up),Physical,Soma,0.0,0,DEPRECIATED,0,1.2,4.8,6,15,100,540,3,30,3,7,1,1",
		  "Rifle,Full-Auto (Ramp-up),Physical,Soma Prime,0.0,0,DEPRECIATED,0.0,1.2,4.8,6,15,200,800,3,30,3,10,1,1",
		  "Pistol,Semi-Auto,Physical,Sonicor,0,0,DEPRECIATED,0,200,0,0,1.25,15,150,3,10,2,25,1,1",
		  "Pistol,Continuous,Physical,Spectra,0,0,DEPRECIATED,0,0,7.6,10.4,12,60,360,1.8,14,2,22,1,0.5",
		  "Pistol,Full-Auto,Physical,Spira,0.0,0,DEPRECIATED,0,8.2,49.2,24.6,2.5,10,210,1,30,2,8,1,1",
		  "Pistol,Full-Auto,Physical,Spira Prime,0.0,0,DEPRECIATED,0,6,48,6,3.33,12,210,0.75,30,3,14,1,1",
		  "Rifle,Full-Auto,Physical,Stadavar (Full-Auto),0.0,0,DEPRECIATED,0.0,9.8,9.8,8.4,10,65,540,2,24,2,12,1,1",
		  "Rifle,Semi-Auto,Physical,Stadavar (Semi-Auto),0.0,0,DEPRECIATED,0.0,7.5,30,12.5,5,65,540,2,28,2,16,1,1",
		  "Pistol,Semi-Auto,Radiation,Staticor (Uncharged),0,0,DEPRECIATED,132,0,0,0,3.5,45,270,1.5,28,2.2,28,1,1",
		  "Shotgun,Semi-Auto,Physical,Strun,0.0,0,DEPRECIATED,0.0,165,45,90,2.5,6,120,3.75,7.5,1.5,20,12,1",
		  "Shotgun,Semi-Auto,Physical,Strun Wraith,0.0,0,DEPRECIATED,0.0,260,60,80,2.5,10,120,5,18,2.2,40,10,1",
		  "Pistol,Full-Auto,Physical,Stubba,0,0,DEPRECIATED,0,14.2,3.3,15.5,6.33,57,399,1.3,23,1.9,13,1,1",
		  "Pistol,Semi-Auto,Corrosive,Stug,1,0,DEPRECIATED,156,0,0,0,4,20,210,2,5,1.5,0,1,1",
		  "Pistol,Charge,Corrosive,Stug (Charge),3,0,DEPRECIATED,936,0,0,0,4,3,210,2,5,1.5,0,1,1",
		  "Rifle,Full-Auto (Ramp-up),Physical,Supra,0,0,DEPRECIATED,0,4,30,6,12.5,180,1080,3,12,1.8,30,1,1",
		  "Rifle,Full-Auto (Ramp-up),Physical,Supra Vandal,0,0,DEPRECIATED,0,4,30,6,12.5,300,1600,3,16,2,30,1,1",
		  "Rifle,Burst,Physical,Sybaris,0.0,2,DEPRECIATED,0,26.4,26.4,27.2,3.98,10,540,2,25,2,10,1,1",
		  "Rifle,Burst,Physical,Sybaris Prime,0.0,2,DEPRECIATED,0,29,29,29.9,4.72,20,540,2,30,2,25,1,1",
		  "Rifle,Continuous,Corrosive,Synapse,0.0,0,DEPRECIATED,20,0.0,0.0,0.0,12,70,540,1.5,39,2.7,13,1,0.5",
		  "Pistol,Continuous,Magnetic,Synoid Gammacor,0,0,DEPRECIATED,20,0,0,0,12,80,400,1.8,20,2,28,1,0.5",
		  "Pistol,Semi-Auto,Blast,Talons,0.0,0,DEPRECIATED,120,0,0,0,3.33,4,12,1,22,2,26,1,1",
		  "Pistol,Semi-Auto,Physical,Telos Akbolto,0.0,0,DEPRECIATED,0.0,4.7,42.3,0,10,30,210,2.6,13,2,29,1,1",
		  "Rifle,Full-Auto,Physical,Telos Boltor,0.0,0,DEPRECIATED,0.0,3,27,0,9.33,90,540,2.4,30,2.4,16,1,1",
		  "Rifle,Full-Auto (Ramp-up),Physical,Tenora,0,0,DEPRECIATED,0,7.2,9.6,7.2,11.67,150,900,2.5,28,2,16,1,1",
		  "Rifle,Charge,Physical,Tenora (Secondary Attack),0.8,0,DEPRECIATED,0,48,144,48,10,15,900,2.5,34,3,11,1,1",
		  "Rifle,Full-Auto,Physical,Tetra,0.0,0,DEPRECIATED,0,6.4,25.6,0,6.67,60,540,2,4,1.5,20,1,1",
		  "Rifle,Burst,Physical,Tiberon,0.0,3,DEPRECIATED,0,11,22,11,9.09,30,540,2.3,26,2.4,16,1,1",
		  "Rifle,Burst,Physical,Tiberon Prime,0.0,3,DEPRECIATED,46,13.8,18.4,13.8,7.38,42,540,2,28,3,20,1,1",
		  "Rifle,Full-Auto,Physical,Tiberon Prime (Full-Auto),0.0,0,DEPRECIATED,0.0,13.8,18.4,13.8,8.33,42,540,2,16,2.8,32,1,1",
		  "Rifle,Semi-Auto,Physical,Tiberon Prime (Semi-Auto),0.0,0,DEPRECIATED,0.0,13.8,18.4,13.8,6,42,540,2,30,3.4,18,1,1",
		  "Shotgun,Burst,Physical,Tigris,0.0,2,DEPRECIATED,0.0,105,105,840,2,2,120,1.8,10,2,28,5,1",
		  "Shotgun,Burst,Physical,Tigris Prime,0.0,4,DEPRECIATED,0.0,156,156,1248,2,2,120,1.8,10,2,30,8,1",
		  "Rifle,Semi-Auto,Blast,Tonkor,0,0,DEPRECIATED,325,0,0,0,2,2,40,2,25,2.5,10,1,1",
		  "Rifle,Semi-Auto,Toxin,Torid (Grenade),0,0,DEPRECIATED,400,0,0,0,1.5,5,60,1.7,15,2,23,1,1",
		  "Pistol,Full-Auto,Physical,Twin Grakatas,0,0,DEPRECIATED,0,8,6.7,5.3,20,60,1200,3,25,2.7,11,2,1",
		  "Pistol,Full-Auto,Physical,Twin Gremlins,0.0,0,DEPRECIATED,0.0,12.33,12.33,12.33,5,30,210,1.1,15,1.5,15,1,1",
		  "Pistol,Full-Auto (Bullet-Ramp),Physical,Twin Kohmak,0.0,0,DEPRECIATED,0.0,30,30,90,6.67,80,210,2.2,11,2,23,5,1",
		  "Pistol,Semi-Auto,Physical,Twin Rogga,0.0,0,DEPRECIATED,0.0,282,352.5,70.5,2.5,2,210,1.5,10,2,33,15,1",
		  "Pistol,Full-Auto,Physical,Twin Vipers,0.0,0,DEPRECIATED,0.0,10.2,1.7,5.1,25,28,210,2,15,1.5,11,1,1",
		  "Pistol,Full-Auto,Physical,Twin Vipers Wraith,0.0,0,DEPRECIATED,0.0,14.4,1.8,1.8,25,40,440,2,19,2,9,1,1",
		  "Pistol,Semi-Auto,Corrosive,Tysis,0,0,DEPRECIATED,79,0,0,0,2.5,11,210,1.2,3,1.5,50,1,1",
		  "Pistol,Semi-Auto,Physical,Vasto,0,0,DEPRECIATED,0,14.5,14.5,29,5,6,210,1,20,1.8,8,1,1",
		  "Pistol,Semi-Auto,Physical,Vasto Prime,1,1,DEPRECIATED,156,9.9,9.9,46.2,5.42,6,210,1,22,2.4,22,1,1",
		  "Shotgun,Semi-Auto,Physical,Vaykor Hek,0.0,0,DEPRECIATED,0.0,78.75,341.25,105,3,8,120,2.25,25,2,25,7,1",
		  "Pistol,Semi-Auto,Physical,Vaykor Marelok,0.0,0,DEPRECIATED,0,96,16,48,2,10,210,1.67,20,1.5,35,1,1",
		  "Rifle,Semi-Auto,Physical,Vectis,0,0,DEPRECIATED,0,90,78.75,56.25,1.5,1,72,1,25,2,30,1,1",
		  "Rifle,Semi-Auto,Physical,Vectis Prime,0.0,0,DEPRECIATED,0,140,157.5,52.5,2.67,2,72,0.85,30,2,30,1,1",
		  "Rifle,Semi-Auto,Physical,Veldt,0.0,0,DEPRECIATED,0.0,23.4,23.4,43.2,3.67,16,528,1.8,22,2.2,22,1,1",
		  "Pistol,Full-Auto,Physical,Viper,0,0,DEPRECIATED,0,10.2,1.7,5.1,14.38,14,210,0.7,15,1.5,11,1,1",
		  "Pistol,Full-Auto,Physical,Viper Wraith,0,0,DEPRECIATED,0,14.4,1.8,1.8,14.38,20,210,0.8,19,2,9,1,1",
		  "Rifle,Semi-Auto,Physical,Vulkar,0,0,DEPRECIATED,0,180,33.8,11.2,1.5,6,72,3,20,2,25,1,1",
		  "Rifle,Semi-Auto,Physical,Vulkar Wraith,0.0,0,DEPRECIATED,0.0,245.7,27.3,0,2,8,72,3,20,2,25,1,1",
		  "Pistol,Full-Auto,Physical,Wraith Twin Vipers,,,,,14.4,1.8,1.8,25,40,210,2,18,2,5,1,1",
		  "Pistol,Semi-Auto,Gas,Zakti (Gas Cloud),0,0,DEPRECIATED,80,0,0,0,5,3,210,0.8,2,1.5,20,1,1",
		  "Rifle,Semi-Auto,Physical,Zarr (Barrage Mode),0.0,0,DEPRECIATED,0.0,240,400,160,3,3,84,2.3,17,2.5,29,10,1",
		  "Rifle,Semi-Auto,Blast,Zarr (With Bomblets),0,0,DEPRECIATED,475,0,0,0,1.67,3,84,2.3,17,2.5,29,1,1",
		  "Rifle,Full-Auto,Physical,Zenith (Full-Auto),0.0,0,DEPRECIATED,0.0,4.5,6,19.5,10.83,90,540,1.4,10,2,34,1,1",
		  "Rifle,Semi-Auto,Physical,Zenith (Semi-Auto),0.0,0,DEPRECIATED,0.0,15,120,15,3,18,540,1.4,35,2.5,8,1,1",
		  "Rifle,Full-Auto,Physical,Zhuge,0.0,0,DEPRECIATED,0.0,5,75,20,4.17,20,540,2.5,20,2,35,1,1",
		  "Pistol,Burst,Physical,Zylok,0.0,2,DEPRECIATED,0,44.8,16.8,78.4,1.8,8,210,1.2,8,2,26,1,1",
		  "Pistol,Continuous,Radiation,Cycron,0,0,DEPRECIATED,10,0,8,5,12,40,999,1,12,1.8,30,1,0.5",
		  "Rifle,Semi-Auto,Physical Only,Nagantaka,0,0,DEPRECIATED,0,1.6,14.3,143.1,2.5,9,540,2,15,2.3,39,1,1",
		  "Pistol,Continuous,Radiation,Ocucor,0,0,DEPRECIATED,22,0,0,0,12,40,210,1.6,16,1.8,24,1,0.5",
		  "Rifle,Burst,Magnetic,Battacor,0.0,2,DEPRECIATED,42,0,24,0,3.57,60,540,2,32,2.4,18,1,1"};
}
