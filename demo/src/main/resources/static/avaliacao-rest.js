// Função para Criar Avaliação (POST)
async function asyncCriarAvaliacao(dadosAvaliacao, proxsucesso, proxerro) {
    const URL = `/api/avaliacao`;  // URL do endpoint para criar uma avaliação
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
        .then(jsonResponse => proxsucesso(jsonResponse))  // Passa a resposta para a função de sucesso
        .catch(proxerro);  // Passa erro caso haja falha
}

// Função para Ler Todas as Avaliações (GET)
async function asyncLerAvaliacoes(proxsucesso, proxerro) {
    const URL = `/api/avaliacao`;  // URL do endpoint para obter todas as avaliações
    fetch(URL)
      .then(resposta => { 
          if (!resposta.ok) throw Error(resposta.status); 
          return resposta;
      })
      .then(resposta => resposta.json())
      .then(jsonResponse => proxsucesso(jsonResponse))  // Passa o array de avaliações para a função de sucesso
      .catch(proxerro);  // Passa erro caso haja falha
}

// Função para Ler Avaliação por ID (GET)
async function asyncLerAvaliacaoById(id, proxsucesso, proxerro) {
    const URL = `/api/avaliacao/${id}`;  // URL do endpoint para obter uma avaliação específica
    fetch(URL)
      .then(resposta => { 
          if (!resposta.ok) throw Error(resposta.status); 
          return resposta; 
      })
      .then(resposta => resposta.json())
      .then(jsonResponse => proxsucesso(jsonResponse))  // Passa a avaliação específica para a função de sucesso
      .catch(proxerro);  // Passa erro caso haja falha
}

// Função para Alterar Avaliação (PUT)
async function asyncAlterarAvaliacao(dadosAvaliacao, proxsucesso, proxerro) {
    const URL = `/api/avaliacao/${dadosAvaliacao.id}`;  // URL do endpoint para alterar uma avaliação existente
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
        .then(jsonResponse => proxsucesso(jsonResponse))  // Passa a resposta para a função de sucesso
        .catch(proxerro);  // Passa erro caso haja falha
}

// Função para Apagar Avaliação (DELETE)
async function asyncApagarAvaliacao(id, proxsucesso, proxerro) {
    const URL = `/api/avaliacao/${id}`;  // URL do endpoint para deletar uma avaliação
    const deleteRequest = {
        method: 'DELETE'
    };
    fetch(URL, deleteRequest)
        .then(resposta => { 
            if (!resposta.ok) throw Error(resposta.status); 
            return resposta; 
        })
        .then(() => proxsucesso())  // Passa sucesso após excluir a avaliação
        .catch(proxerro);  // Passa erro caso haja falha
}
