import React from 'react';

const FiveChild2App = ({photo,msg}) => {
    return (
        <div className={'box1'}>
            <img src={photo} alt={msg} className={'photo'}/>
        </div>
    );
};

export default FiveChild2App;