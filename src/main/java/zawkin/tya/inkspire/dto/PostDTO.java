package zawkin.tya.inkspire.dto;

import java.time.LocalDateTime;

public record PostDTO(
        String id,
        String title,
        LocalDateTime createdDate
) {
}
