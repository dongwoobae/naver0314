import React from 'react';
import {Alert, Button} from "@mui/material";
import {useNavigate} from "react-router-dom";

const Home = () => {
    const navi=useNavigate();
    return (
        <div>
            <Alert>Home 화면</Alert>
            <h4>&emsp;페이지 이동 연습</h4>
            &emsp;<Button variant={'contained'} size={'small'} onClick={()=>navi('/about/Samsung')}>About Page로 이동</Button>&emsp;
            <Button variant={'contained'} size={'small'} color={'success'}  onClick={()=>navi('/member')}>
                Member Page로 이동</Button>&emsp;
            <Button variant={'contained'} size={'small'} color={'error'} onClick={()=>navi('/mycar/list')}>
                MyCar Page로 이동</Button>
        </div>
    );
};

export default Home;
