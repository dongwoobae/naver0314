package data.mapper;

import data.dto.GuestDto;
import data.dto.GuestPhotoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GuestMapperinter {
    public void insertGuest(GuestDto dto);
    public void insertGuestPhoto(GuestPhotoDto dto);
    public List<GuestDto> selectAllGuest();
}
