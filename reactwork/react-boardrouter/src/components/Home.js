import React from 'react';
import {Alert} from "@mui/material";

const Home = () => {
    return (
        <div>
            <Alert style={{marginBottom:'10px'}}>Home - 메인입니다</Alert>
            <div>
                <img src={require('../image/mainimage/K-034.png')} alt={''} style={{width:'200px',height:'200px'}}/>
                <img src={require('../image/mainimage/K-035.png')} alt={''} style={{width:'200px',height:'200px'}}/>
            </div>
        </div>
    );
};

export default Home;
