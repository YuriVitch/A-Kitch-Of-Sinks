package net.yurivitch.asok.Item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SuperTestItem extends Item {

    public SuperTestItem(Properties properties) {
        super(properties);
    }
    
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){
            if(getRandomNumber() < 5){
                output(player, "Its so over");
            }
            else{
                output(player, "we're so back");
            }
            player.getCooldowns().addCooldown(this, 20);
        }

        return super.use(level, player, hand);
    }

    private void output(Player player, String output){
        player.sendSystemMessage(Component.literal(output));
    }

    private int getRandomNumber(){
        return RandomSource.createNewThreadLocalInstance().nextInt(10);
    }
}
