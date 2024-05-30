package data.service;

import data.dto.GuestDto;
import data.dto.GuestPhotoDto;
import data.mapper.GuestMapperinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestService {
    @Autowired
    private GuestMapperinter guestMapper;

    public void insertGuest(GuestDto dto){
        guestMapper.insertGuest(dto);
    }
    public void insertGuestPhoto(GuestPhotoDto dto){
        guestMapper.insertGuestPhoto(dto);
    }
}
