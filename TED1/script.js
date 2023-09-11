
const produtos = [
    { nome: 'Geladeira', preco: 3000 },
    { nome: 'Maquina de Lavar', preco: 3400 },
    { nome: 'Panela', preco: 300 }
  ];
  
  const produtosComAumento = produtos.map(produto => {
    return {
      nome: produto.nome,
      preco: produto.preco * 1.5
    };
  });
  
  console.log(produtosComAumento);
