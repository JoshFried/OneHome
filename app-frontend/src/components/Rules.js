import React from "react"
function Rules(props)
{
    return(
      <div>
        <div>{props.males ? <div>Males are allowed</div> : <div>Males are not allowed</div>}</div>
        <div>{props.females ? <div>Females are allowed</div> : <div>Females are not allowed</div>}</div>
        <div>{props.sober ? <div>No drinking</div> : <div>Drinking is allowed</div>}</div>
        <div>{props.minor ? <div>Minors are allowed</div> : <div>Minors are not allowed</div>}</div>
        <div>{props.pets ? <div>Pets are allowed</div> : <div>Pets are not allowed</div>}</div>
    </div>  
    )
}
export default Rules