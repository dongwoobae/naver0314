package data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("GuestPhotoDto")
public class GuestPhotoDto {
    private int photoidx;
    private int guestidx;
    private String photoname;
}
