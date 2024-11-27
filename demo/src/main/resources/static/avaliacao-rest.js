// Função para criar uma nova avaliação
async function asyncCriarAvaliacao(dadosAvaliacao, proxsucesso, proxerro) {
    const URL = `/api/avaliacao`;
    const postRequest = {
        method: 'POST',
        body: JSON.stringify(dadosAvaliacao),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, postRequest)
        .then(resposta => {
            if (!resposta.ok) throw Error(resposta.status);
            return resposta;
        })
        .then(resposta => resposta.json())
        .then(jsonResponse => proxsucesso())
        .catch(proxerro);
}

// Função para listar todas as avaliações
async function asyncLerAvaliacoes(proxsucesso, proxerro) {
    const URL = `/api/avaliacao`;
    fetch(URL)
        .then(resposta => {
            if (!resposta.ok) throw Error(resposta.status);
            return resposta;
        })
        .then(resposta => resposta.json())
        .then(jsonResponse => proxsucesso(jsonResponse))
        .catch(proxerro);
}

// Função para buscar uma avaliação pelo ID
async function asyncLerAvaliacaoById(id, proxsucesso, proxerro) {
    const URL = `/api/avaliacao/${id}`;
    fetch(URL)
        .then(resposta => {
            if (!resposta.ok) throw Error(resposta.status);
            return resposta;
        })
        .then(resposta => resposta.json())
        .then(jsonResponse => proxsucesso(jsonResponse))
        .catch(proxerro);
}

// Função para alterar uma avaliação existente
async function asyncAlterarAvaliacao(dadosAvaliacao, proxsucesso, proxerro) {
    const URL = `/api/avaliacao/${dadosAvaliacao.id}`;
    const putRequest = {
        method: 'PUT',
        body: JSON.stringify(dadosAvaliacao),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, putRequest)
        .then(resposta => {
            if (!resposta.ok) throw Error(resposta.status);
            return resposta;
        })
        .then(resposta => resposta.json())
        .then(jsonResponse => proxsucesso())
        .catch(proxerro);
}

// Função para apagar uma avaliação
async function asyncApagarAvaliacao(id, proxsucesso, proxerro) {
    const URL = `/api/avaliacao/${id}`;
    const deleteRequest = {
        method: 'DELETE'
    };
    fetch(URL, deleteRequest)
        .then(resposta => {
            if (!resposta.ok) throw Error(resposta.status);
            return resposta;
        })
        .then(() => proxsucesso())
        .catch(proxerro);
}
