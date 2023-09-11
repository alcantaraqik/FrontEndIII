
// Criar o array de objetos de produtos
const produtos = [
    { nome: 'Geladeira', preco: 3000 },
    { nome: 'Maquina de Lavar', preco: 3400 },
    { nome: 'Panela', preco: 300 }
  ];
  
  // Usar o método map() para aplicar um aumento de preço de 1.5 para cada produto
  const produtosComAumento = produtos.map(produto => {
    return {
      nome: produto.nome,
      preco: produto.preco * 1.5
    };
  });
  
  // Exibir o resultado no console
  console.log(produtosComAumento);