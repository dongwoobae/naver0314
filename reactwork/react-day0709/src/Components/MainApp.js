import React from 'react';
import OneApp from "./OneApp";
import TwoApp from "./TwoApp";
import ThreeApp from "./ThreeApp";
import FourApp from "./FourApp";
import FiveApp from "./FiveApp";
import SixApp from "./SixApp";

const MainApp = () => {
    const [idx, setIdx] = React.useState(1);
    return (
        <div>
            <h3>2024 07 09 리액트 수업</h3>
            <br/>
            <select className={"form-select"} style={{width: '300px'}} defaultValue={idx}
            onChange={(e)=>{
                setIdx(Number(e.target.value));
            }}>
                <option value={1}>OneApp-styled-component</option>
                <option value={2}>TwoApp</option>
                <option value={3}>ThreeApp</option>
                <option value={4}>FourApp</option>
                <option value={5}>FiveApp</option>
                <option value={6}>SixApp</option>
            </select>
            <br/><br/>
            {
                idx===1?<OneApp/>:idx===2?<TwoApp/>:
                    idx===3?<ThreeApp/>:idx===4?<FourApp/>:
                        idx===5?<FiveApp/>:<SixApp/>
            }
        </div>
    );
};

export default MainApp;