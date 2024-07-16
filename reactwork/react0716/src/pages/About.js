import React from 'react';
import {Alert} from "@mui/material";
import {NavLink, useParams} from "react-router-dom";
import nojobPhoto from '../image/snoopyAvata/s1.JPG';

const About = () => {
    const {company}=useParams();
    let photo;
    if(company==='Samsung'){
        photo='Samsung.svg'
    }else if(company==='Naver'){
        photo='Naver.png'
    }
    return (
        <div>
            <Alert severity={'warning'}>About 화면</Alert>
            <div>
                {
                    company==null?
                        <div style={{marginTop: '20px'}}>
                            <b>저는 현재 취업 준비중 입니다 따흐흑</b><br/>
                            <img src={nojobPhoto} alt={''}/>
                        </div>:
                        <div>
                            <b>저는 현재 {company}에 다니고 있습니다</b><br/>
                            <img src={require(`../image/${photo}`)} alt={company} width={'200px'}/><br/>
                            <a href={`https://www.${company}.com`}>{company}</a>
                        </div>
                }
            </div>
        </div>
    );
};

export default About;
