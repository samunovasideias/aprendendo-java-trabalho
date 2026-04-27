const novo=document.getElementById("novoleitor");
novo.addEventListener("submit", async (event)=>{
    event.preventDefault();
    dados1={
        nome:document.getElementById("novonome").value,
        sobrenome:document.getElementById("novosobrenome").value,
    }
    const response=await fetch("http://localhost:8080/leitor/criar",{
        method:"POST",
        headers:{
        'Content-Type':'application/json'
        },
        body:JSON.stringify(dados1),


    })
    if (response.ok){
        novo.reset()
    }else{
        console.error("erro",response.status)
    }
})
