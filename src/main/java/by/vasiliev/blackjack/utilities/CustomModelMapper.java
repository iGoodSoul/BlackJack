package by.vasiliev.blackjack.utilities;

import by.vasiliev.blackjack.models.Player;
import by.vasiliev.blackjack.models.dto.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@Component
public class CustomModelMapper {


   private final ModelMapper modelMapper;

    public CustomModelMapper() {
        this.modelMapper = new ModelMapper();
    }

    public Player convertFromPlayerDTO(PlayerDTO playerDTO){
        return modelMapper.map(playerDTO, Player.class);
    }

    public PlayerDTO convertFromPlayer(Player player){
        return modelMapper.map(player, PlayerDTO.class);
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }
}