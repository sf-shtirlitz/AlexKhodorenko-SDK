package net.aksdk.movieservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "MovieDto Model Info"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private Long id;
    @Schema(
            description = "Movie Name"
    )
    private String movieName;

    @Schema(
            description = "Famous quote"
    )
    private String movieQuote;
}
