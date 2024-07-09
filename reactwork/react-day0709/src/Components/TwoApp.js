import React, {useState} from "react";
import talent1 from "../image/1.jpg";

const TwoApp =()=>{
    const [talent,setTalent]=useState(19);
    const handler=(e)=>{
        setTalent(e.target.value);
    }
    return (
        <div>
            <h3 className={"alert alert-info"}>TwoApp-이미지 불러오기</h3>
            <h5>import로 가져오는 방법</h5>
            <img src={talent1} alt={"사진"} width={100}/>
            <h5>require를 이용해서 이미지 가져오기</h5>
            <img src={require('../image/2.jpg')} alt={require('../image/3.jpg')} width={100}/>
            <h5>radio button을 이용하여 이미지 바꿔서 출력해보기</h5>
            <label><input name={"talent"} type={"radio"} value={19}
            onChange={handler} checked={Number(talent)===19}/>&nbsp;수지</label>
            <label><input name={"talent"} type={"radio"} value={20}
                          onChange={handler} checked={Number(talent)===20}/>&nbsp;유아인</label>
            <label><input name={"talent"} type={"radio"} value={17}
                          onChange={handler} checked={Number(talent)===17}/>&nbsp;신민아</label>
            <label><input name={"talent"} type={"radio"} value={14}
                          onChange={handler} checked={Number(talent)===14}/>&nbsp;유승호</label><br/>
            <img src={require(`../image/${talent}.jpg`)} alt={'연예인 사진'} width={200}/>
        </div>
    )
}

export default TwoApp;