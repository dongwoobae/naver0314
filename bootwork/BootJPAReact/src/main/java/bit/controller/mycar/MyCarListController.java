package bit.controller.mycar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import bit.data.mycar.MycarDto;
import bit.service.mycar.MyCarService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class MyCarListController {
	final MyCarService myCarService;
	final NcpObjectStorageService storageService;
	
	private String bucketName="mycar";
	private String folderName="MyCarPhotos";

	private String uploadPhotoname;
	
	@GetMapping("/mycar/list")
	public List<MycarDto> list()
	{
		return myCarService.getAllDatas();
	}

	@PostMapping("/mycar/upload")
	public Map<String,String> uploadPhoto(@RequestParam("upload") MultipartFile upload){
		System.out.println("photo upload>> " + upload.getOriginalFilename());
		//스토리지에 업로드 후 업로드 된 파일명 반환
		String carphoto = storageService.uploadFile(bucketName,folderName,upload);
		System.out.println("stored name>>"+carphoto);

		Map<String,String> map=new HashMap<>();
		map.put("carphoto",carphoto);
		return map;
	}

	//dto 데이터를 db 저장(json을 dto로 변환해서 받을 때 RequestBody 사용)
	@PostMapping("/mycar/insert")
	public void insert(@RequestBody MycarDto mycarDto){
		System.out.println("insert dto>>"+mycarDto);
		myCarService.insertMycar(mycarDto);
	}

	@DeleteMapping("/mycar/delete")
	public void delete(@RequestParam("num") Long num,
					   @RequestParam("photo") String photo){
		storageService.deleteFile(bucketName,folderName,photo);
		myCarService.deleteMycar(num);
	}

	@PostMapping("/mycar/update")
	public void update(@RequestBody MycarDto mycarDto){
		System.out.println("update dto>>"+mycarDto);
		myCarService.updateMycar(mycarDto);
	}
	

}
