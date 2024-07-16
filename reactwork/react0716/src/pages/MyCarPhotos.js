import React, {useEffect} from 'react';
import axios from "axios";
import {ImageList, ImageListItem, ImageListItemBar} from "@mui/material";

const MyCarPhotos = () => {
    const [imageList,setImageList] = React.useState([]);
    const loadImageList = () => {
        axios.get("/mycar/list").then((response) => {
            setImageList(response.data);
        })
    }
    useEffect(()=>{
        loadImageList();
    },[]);
    const photopath="https://kr.object.ncloudstorage.com/mycar/MyCarPhotos";
    return (
        <div>
            <div style={{width:'1300px',textAlign:'center',fontSize:'20px',fontWeight:'bold',height:'50px'}}>차량 이미지 목록</div>
            <ImageList sx={{width:'1500px'}} cols={4} rowHeight={300}>
                {
                    imageList.map((item, index) => {
                        return(
                            <ImageListItem key={index}>
                                <img
                                    srcSet={`${photopath}/${item.carphoto}?w=248&fit=crop&auto=format&dpr=2 2x`}
                                    src={`${photopath}/${item.carphoto}?w=248&fit=crop&auto=format`}
                                    alt={item.carname}
                                    loading="lazy"
                                    border={5}
                                />
                                <ImageListItemBar position="bottom" title={item.carname}/>
                            </ImageListItem>
                        )
                    })
                }
            </ImageList>
        </div>
    );
};

export default MyCarPhotos;
