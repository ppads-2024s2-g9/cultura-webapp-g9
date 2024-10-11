async function asyncCriarInstru(dadosInstrumento, proxsucesso, proxerro) {
    const URL = `/api/instrumento`;
    const postRequest = {
        method: 'POST',
        body: JSON.stringify(dadosInstrumento),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, postRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; } )
        .then(resposta => resposta.json())
        .then(jsonResponse => proxsucesso())
        .catch(proxerro);
}

async function asyncLerInstru(proxsucesso, proxerro) {
    const URL = `/api/instrumento`;
    fetch(URL)
      .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta;}) 
      .then(resposta => resposta.json())
      .then(jsonresponse => proxsucesso(jsonresponse))
      .catch(proxerro);
}

async function asyncLerInstruById(id, proxsucesso, proxerro) {
    const URL = `/api/instrumento/${id}`;
    fetch(URL)
      .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta;}) 
      .then(resposta => resposta.json())
      .then(jsonresponse => proxsucesso(jsonresponse))
      .catch(proxerro);
}

async function asyncAlterarInstru(dadosInstrumento, proxsucesso, proxerro) {
    const URL = `/api/instrumento/${dadosInstrumento.id}`;
    const putRequest = {
        method: 'PUT',
        body: JSON.stringify(dadosInstrumento),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, putRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; } )
        .then(resposta => resposta.json())
        .then(jsonResponse => proxsucesso())
        .catch(proxerro);	        	
}

async function asyncApagarInstru(id, proxsucesso, proxerro) {
    const URL = `/api/instrumento/${id}`;
    const deleteRequest = {
        method: 'DELETE'
    };
    fetch(URL, deleteRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; } )
        .then(resposta => proxsucesso())
        .catch(proxerro);	        		
}