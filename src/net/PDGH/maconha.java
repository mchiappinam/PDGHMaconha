package net.pdgh;

//import org.bukkit.Bukkit;


import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class maconha extends JavaPlugin implements Listener {

	
	  private boolean maldade = true;
	  private boolean ReloadAliasesOnFirstWorldChange;
	  private boolean EfeitosMaconha;
	  private boolean EfeitosCrack;
	  private boolean Kick_first;
	  private boolean ComandosStop_lag;
	  private boolean ComandosCores;
	  
	  
    @Override
    public void onEnable(){
		File file = new File(getDataFolder(),"config.yml");
		if(!file.exists()) {
			try {
				saveResource("config_template.yml",false);
				File file2 = new File(getDataFolder(),"config_template.yml");
				file2.renameTo(new File(getDataFolder(),"config.yml"));
			}
			catch(Exception e) {}
		}
		getServer().getPluginManager().registerEvents(this, this);
    	//tagsRedondas();
    	reloadAliases();
		if(EfeitosMaconha = (getConfig().getString("Efeitos.Maconha")=="true")) {
			EfeitosMaconha=true;
		}
		if(EfeitosCrack = (getConfig().getString("Efeitos.Crack")=="true")) {
			EfeitosCrack=true;
		}
		if(Kick_first = (getConfig().getString("Kick_first")=="true")) {
			Kick_first=true;
		}
		if(ComandosStop_lag = (getConfig().getString("Comandos.Stop_lag")=="true")) {
			ComandosStop_lag=true;
		}
		if(ComandosCores = (getConfig().getString("Comandos.Cores")=="true")) {
			ComandosCores=true;
		}
		if(ReloadAliasesOnFirstWorldChange = (getConfig().getString("Comandos.ReloadAliasesOnFirstWorldChange")=="true")) {
			ReloadAliasesOnFirstWorldChange=true;
		}
    	getLogger().info("PDGHMaconha ativado - Plugin by: mchiappinam");
    	getLogger().info("Acesse: http://pdgh.net/");
    }
    @Override
    public void onDisable() {
    	getLogger().info("PDGHMaconha desativado - Plugin by: mchiappinam");
    	getLogger().info("Acesse: http://pdgh.net/");
    }
    

	  
	  
	  /**public void tagsRedondas()
	  {
	    getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable()
	    {
	      public void run()
	      {
	    	  getServer().dispatchCommand(getServer().getConsoleSender(), "pex group VIP prefix &6➥ⓋⒾⓅ&f");
	    	  getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Diretor prefix &3➥Ⓓⓘⓡⓔⓣⓞⓡ&f");
	    	  getServer().dispatchCommand(getServer().getConsoleSender(), "pex group VIPeCoordenador prefix &6➥ⓋⒾⓅ&a[Coordenador]&f");
	    	  getServer().dispatchCommand(getServer().getConsoleSender(), "pex group VIPeModerador prefix &6➥ⓋⒾⓅ&2&l[Moderador]&f");
	      }
	    }, 1 * 20L);
	  }*/

	  public void reloadAliases()
	  {
	    getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable()
	    {
	      public void run()
	      {
	  		if (ComandosStop_lag==true) {
		    	  getServer().dispatchCommand(getServer().getConsoleSender(), "stoplag");
	  		}
	    	  getServer().dispatchCommand(getServer().getConsoleSender(), "rg flag end -w world_the_end invincible");
	    	  getServer().dispatchCommand(getServer().getConsoleSender(), "reloadaliases");
	    	  getServer().dispatchCommand(getServer().getConsoleSender(), "reloadaliases");
	    	  getServer().dispatchCommand(getServer().getConsoleSender(), "reloadaliases");
	      }
	    }
	    , 7 * 20L);
	  }
    
	  
	  
    @Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
  		final Player player1 = (Player) sender;
		if(args.length == 0)
		if(commandLabel.equalsIgnoreCase("maconha")){
			if (!player.hasPermission("pdghmaconha.use.maconha")) {
				player.sendMessage("§4[PDGH] Sem permissoes");
			 }else if(args.length > 1) {
	             player.sendMessage("Sintaxe");
                return true;
            }
	  		if (EfeitosMaconha==true) {
	     //player.sendMessage(ChatColor.GOLD + "pdgh.net");
	     Bukkit.broadcastMessage("§9[/Maconha] §c" + player.getPlayerListName() + " §aesta fumando uma maconha.");
	     //player.sendMessage("§9[/maconha] §cVoce §aesta fumando uma maconha.");
         //player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 500, 1));
         player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 500, 10));
         player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 500, 0));
         //player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 0));
         player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 500, 1));
         player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 500, 0));
         
	   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                public void run() {
			    	 player1.playSound(player1.getLocation(), Sound.GLASS, 1.0F, (byte) 30);
                  }
        },5L);
	   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                public void run() {
			    	 player1.playSound(player1.getLocation(), Sound.GLASS, 1.0F, (byte) 30);
                  }
        },15L);
	   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                public void run() {
			    	 player1.playSound(player1.getLocation(), Sound.GLASS, 1.0F, (byte) 30);
                  }
        },25L);
	   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                public void run() {
			    	 player1.playSound(player1.getLocation(), Sound.GLASS, 1.0F, (byte) 30);
                  }
        },35L);
	   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                public void run() {
			    	 player1.playSound(player1.getLocation(), Sound.GLASS, 1.0F, (byte) 30);
                  }
        },45L);
	   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                public void run() {
			    	 player1.playSound(player1.getLocation(), Sound.GLASS, 1.0F, (byte) 30);
                  }
        },55L);
	   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                public void run() {
			    	 player1.playSound(player1.getLocation(), Sound.GLASS, 1.0F, (byte) 30);
                  }
        },65L);
	   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                public void run() {
                    player1.sendMessage("§c§lSua maconha acabou! §4§l:'(");
                    player1.sendMessage("§3§lCompre mais com §f§l/maconha");
                  }
        },550L);

			/**try {
				wait(30000);
				player.sendMessage("§cSua maconha acabou. §2Compre mais com §8/maconha");
			} catch (InterruptedException e) {
				//Auto-generated catch block
				e.printStackTrace();
			}*/
	  		}
         }
		if(args.length == 0)
		if(commandLabel.equalsIgnoreCase("crack")){
				if (!player.hasPermission("pdghmaconha.use.crack")) {
					player.sendMessage("§4[PDGH] Sem permissoes");
				 }else if(args.length > 1) {
		             player.sendMessage("Sintaxe");
	                return true;
	            }
		  		if (EfeitosCrack==true) {
			         Bukkit.broadcastMessage("§9[/Crack] §c" + player.getPlayerListName() + " §aesta fumando um crack.");
				     //Bukkit.broadcastMessage("§9[/crack] §c" + player.getDisplayName() + " §aesta fumando um crack.");
				     //player.sendMessage("§9[/crack] §cVoce §aesta fumando um crack.");
				     //player.sendMessage("§cLembrando que estamos tentando aprimorar os efeitos.");
				     //player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 500, 1));
			         player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 500, 10));
			         player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 500, 0));
			         //player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 0));
			         player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 500, 1));
			         //player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 500, 1));
			         player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 500, 1));
			         
   				   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
		                         public void run() {
		    				    	 player1.playSound(player1.getLocation(), Sound.BLAZE_HIT, 1.0F, (byte) 30);
		                           }
		                 },40L);
   				   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	                         public void run() {
	    					     player1.playSound(player1.getLocation(), Sound.BLAZE_HIT, 1.0F, (byte) 30);
	                           }
	                 },80L);
   				   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	                         public void run() {
	    					     player1.playSound(player1.getLocation(), Sound.ANVIL_BREAK, 1.0F, (byte) 30);
	                           }
	                 },120L);
   				   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	                         public void run() {
	    					     player1.playSound(player1.getLocation(), Sound.BLAZE_HIT, 1.0F, (byte) 30);
	                           }
	                 },160L);
   				   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	                         public void run() {
	    					     player1.playSound(player1.getLocation(), Sound.ANVIL_USE, 1.0F, (byte) 30);
	                           }
	                 },200L);
   				   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	                         public void run() {
	    					     player1.playSound(player1.getLocation(), Sound.GHAST_SCREAM, 1.0F, (byte) 30);
	                           }
	                 },240L);
   				   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	                         public void run() {
	    					     player1.playSound(player1.getLocation(), Sound.GHAST_SCREAM2, 1.0F, (byte) 30);
	                           }
	                 },280L);
   				   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	                         public void run() {
	    					     player1.playSound(player1.getLocation(), Sound.GHAST_MOAN, 1.0F, (byte) 30);
	                           }
	                 },320L);
   				   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	                         public void run() {
	    					     player1.playSound(player1.getLocation(), Sound.IRONGOLEM_HIT, 1.0F, (byte) 30);
	                           }
	                 },360L);
   				   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	                         public void run() {
	    					     player1.playSound(player1.getLocation(), Sound.PIG_DEATH, 1.0F, (byte) 30);
	                           }
	                 },400L);
   				   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	                         public void run() {
	    					     player1.playSound(player1.getLocation(), Sound.WITHER_DEATH, 1.0F, (byte) 30);
	                           }
	                 },440L);
   				   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	                         public void run() {
	    					     player1.playSound(player1.getLocation(), Sound.WITHER_SPAWN, 1.0F, (byte) 30);
	                           }
	                 },480L);
   				   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	                         public void run() {
	    				    	 player1.playSound(player1.getLocation(), Sound.ENDERDRAGON_DEATH, 1.0F, (byte) 30);
	                           }
	                 },520L);
   				   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	                         public void run() {
	    						 player1.playSound(player1.getLocation(), Sound.DOOR_OPEN, 1.0F, (byte) 30);
	                           }
	                 },550L);
   				   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	                         public void run() {
	    						 player1.playSound(player1.getLocation(), Sound.DOOR_CLOSE, 1.0F, (byte) 30);
	                           }
	                 },550L);
   				   		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	                         public void run() {
	                             player1.sendMessage("§c§lSeu crack acabou! §4§l:'(");
	                             player1.sendMessage("§3§lCompre mais com §f§l/crack");
	                           }
	                 },550L);
				    }
		}
		if(args.length == 0)
 if (commandLabel.equalsIgnoreCase("cores")) {
      if (!player.hasPermission("pdgh.membro")) {
        player.sendMessage("§4[PDGH] Sem permissoes");
		 }else if(args.length > 1) {
             player.sendMessage("Sintaxe");
            return true;
        }
		if (ComandosCores==true) {
      player.sendMessage(" ");
      player.sendMessage(" ");
      player.sendMessage("§6§lCores VIP - §0&0 §1&1 §2&2 §3&3 §4&4 §5&5 §6&6 §7&7 §8&8 §9&9 §a&a §b&b §c&c §d&d §e&e §f&f");
      player.sendMessage(" ");
      player.sendMessage(" ");
		}
 }
    return false;
  }

	  @EventHandler
	        public void onPlayerJoin(PlayerJoinEvent event) {
          if(maldade==true) {
          final Player p = event.getPlayer();
	   			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	               
	                         public void run() {
	               	    	  getServer().dispatchCommand(getServer().getConsoleSender(), "reloadaliases");
	                	  		if (Kick_first==true) {
	                                      p.kickPlayer("§fEnd of stream");
	                	  		}
	                   	               maldade=false;
	                           }
	                 },40L);
	   			
	   			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                    public void run() {
                   	    	  getServer().dispatchCommand(getServer().getConsoleSender(), "reloadaliases");
              	               maldade=false;
                      }
            },600L);
	           }
	        }
	  
	  @EventHandler
      public void onWorldChange(PlayerChangedWorldEvent event) {
    if(ReloadAliasesOnFirstWorldChange==true) {
 			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
             
                       public void run() {
             	    	  getServer().dispatchCommand(getServer().getConsoleSender(), "reloadaliases");
             	    	 ReloadAliasesOnFirstWorldChange=false;
                         }
               },300L);
         }
      }
}