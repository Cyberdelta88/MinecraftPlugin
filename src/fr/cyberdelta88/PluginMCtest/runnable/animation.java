package fr.cyberdelta88.PluginMCtest.runnable;

import org.bukkit.entity.ArmorStand;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

public class animation extends BukkitRunnable {
    ArmorStand s;

    public animation(ArmorStand stand) {
        s = stand;
    }


    @Override
    public void run() {
        EulerAngle oldRot = s.getRightArmPose();
        EulerAngle newrot = oldRot.add(1f, 0, 0);
        s.setRightArmPose(newrot);
    }

}
