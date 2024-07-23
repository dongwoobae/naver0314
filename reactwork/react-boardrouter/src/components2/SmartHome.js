import React, {useCallback, useState} from 'react';
import Light from "./Light";

const SmartHome = () => {
    const [masterOn,setMasterOn]=useState(false);
    const [kitchenOn,setKitchenOn]=useState(false);
    const [bathOn,setBathOn]=useState(false);

    // const toggleMaster=()=>{
    //     setMasterOn(!masterOn);
    // }
    // const toggleKitchen=()=>{
    //     setKitchenOn(!kitchenOn);
    // }
    // const toggleBath=()=>{
    //     setBathOn(!bathOn);
    // }
    // 전체 렌더링이 아니라 하나만 렌더링 시키는 방법
    // 불러오는 하위 component에 export를 할때 React.memo()로 export 시킨 뒤 callback 함수로 호출하면 됨
    const toggleMaster= useCallback(
        () => {
            setMasterOn(!masterOn)
        },
        [masterOn],
    );
    const toggleKitchen=useCallback(
        ()=>{
            setKitchenOn(!kitchenOn);
        },
        [kitchenOn]
    );
    const toggleBath=useCallback(
        ()=>{
            setBathOn(!bathOn);
        },
        [bathOn]
    )

    return (
        <div style={{margin:'100px 100px'}}>
            <Light room={'침실'} on={masterOn} toggle={toggleMaster}/>
            <Light room={'주방'} on={kitchenOn} toggle={toggleKitchen}/>
            <Light room={'욕실'} on={bathOn} toggle={toggleBath}/>
        </div>
    );
};

export default SmartHome;
