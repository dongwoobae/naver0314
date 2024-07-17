package bit.controller.board;

import bit.data.board.BoardDto;
import bit.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boot/board")
public class BoardController {

    private final BoardService boardService;
    private final NcpObjectStorageService storageService;

    String bucketName="mycar";
    String folderName="ReactBoard";

    @PostMapping("/insertPhoto")
    public String photoUpload(@RequestParam("upload") MultipartFile upload){
        System.out.println("upload>>"+upload.getOriginalFilename());
        String photoname=storageService.uploadFile(bucketName,folderName,upload);

        return photoname;
    }

    @PostMapping("/insert")
    public void boardInsert(@RequestBody BoardDto dto){
        System.out.println("dto>>"+dto);
        boardService.insertBoard(dto);
    }

    @GetMapping("/list")
    public List<BoardDto> list(){
        System.out.println("list>>");
        return boardService.getAllDatas();
    }

    @GetMapping("/detail")
    public BoardDto detail(@RequestParam("boardNum") Long boardNum){
        System.out.println("detail>>"+boardNum);
        boardService.updateReadCount(boardNum);
        return boardService.getData(boardNum);
    }

    @GetMapping("/updatecheckpass")
    public Map<String,Object> checkPass(@RequestParam("boardNum") Long boardNum,
                                        @RequestParam("pass") String pass){
        Map<String,Object> map=new HashMap<>();
        boolean flag=boardService.isEqualPass(boardNum,pass);

        if(flag){
            BoardDto boardDto=boardService.getData(boardNum);
            map.put("boardDto",boardDto);
            map.put("result","success");
        }else {
            map.put("result", "fail");
        }

        return map;
    }

    @PostMapping("/update")
    public void update(@RequestBody BoardDto dto){
        System.out.println("dto>>"+dto);
        boardService.updateBoard(dto);
    }

    @GetMapping("/deletecheckpass")
    public Map<String,Object> deletePass(@RequestParam("boardNum") Long boardNum,
                           @RequestParam("pass") String pass){
        Map<String,Object> map=new HashMap<>();
        boolean flag=boardService.isEqualPass(boardNum,pass);
        if(flag){
            String oldPhotoName=boardService.getData(boardNum).getPhoto();
            storageService.deleteFile(bucketName,folderName,oldPhotoName);
            boardService.deleteBoard(boardNum);
            map.put("result","success");
        }else{
            map.put("result","fail");
        }
        return map;
    }


}
