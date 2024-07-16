import React from 'react';
import {Alert} from "@mui/material";
import {NavLink, Route, Routes} from "react-router-dom";
import MyCarList from "./MyCarList";
import MyCarPhotos from "./MyCarPhotos";


const MyCar = () => {
    return (
        <div>
            <Alert severity={'info'}>My Car Data Base</Alert>
            <ul className={'menu'} style={{marginTop:'20px'}}>
                <li>
                    <NavLink to={'/mycar/list'}>목록</NavLink>
                </li>
                <li>
                    <NavLink to={'/mycar/photos'}>사진들</NavLink>
                </li>
            </ul><br/><br/><br/>
            <Routes>
                <Route path={'/list'} element={<MyCarList/>}/>
                <Route path={'/photos'} element={<MyCarPhotos/>}/>
            </Routes>
        </div>
    );
};

export default MyCar;
