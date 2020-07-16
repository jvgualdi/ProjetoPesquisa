# ProjetoPesquisa
Unsupervised Machine Learning Based on Heterogeneous Networks for Text Clustering.

Pesquisa realizada na Universidade Federal de Mato Grosso do Sul no período de 08/2018 à 07/2019.
Foram implementados algoritmos k-Means, Bisecting k-Means, Non-Negative Matrix Factorization, Gaussian Mixture Models, Latent Dirichlet Allocation,
Label Propagation para rede de similaridade k-Nearst Neighbors em uma ligação homogênea e uma ligação heterogênea, Simple Ranking e Rank Clustering.

Para bases de textos utilizadas na representação TF-IDF e TF o algoritmo Label Propagation obteve o melhor média de resultado para certa de 20 das 30 amostras.


Atualmente há uma quantidade massiva de textos sendo produzida, a qual contém
conhecimento útil na área acadêmica ou empresarial. Entretanto, devido à grande quantidade
de textos, torna-se humanamente impossível organizar e extrair conhecimento
embutido nos textos. Técnicas para automatizar tais tarefas, como o agrupamento de
dados, têm sido empregadas. Porém, a maioria dos algoritmos de agrupamento são
baseado no modelo espaço-vetorial (MEV), na qual os documentos são representados
por vetores e as dimensões correspondem aos termos. Algoritmos baseados no MEV
normalmente obtém grupos de documentos em regiões de formatos pré-definidos, ou
ainda, quando não têm tal caraterística, possuem complexidade de tempo e espaço
quadráticas. Por outro lado, as representações em redes permitem modelar diferentes
tipos de relações entre textos, são capazes de capturar padrões dificilmente capturados
pelo MEV, e algoritmos de agrupamento em redes, como a propagação de rótulos,
possuem complexidade linear. Porém, o agrupamento em redes não tem sido explorado
(i) especificamente no agrupamento de textos; e (ii) com as diferentes possibilidades de
representar textos em redes. Com isso, o objetivo deste projeto de IC é a exploração
e proposta de técnicas de agrupamento baseado em rede aplicada a diferentes tipos
de representações em redes. Foram realizados experimentos utilizando 30 coleções de
diferentes domínios, representadas em formato bag-of-words, redes de similaridade do
tipo k-Nearest Neighbors e redes bipartidas. A abordagem de propagação de rótulos em
redes de similaridade obteve os melhores resultados para a maior parte das medidas
de avaliação e para a grande maioria das coleções considerando as medidas Accuracy,
Purity, Entropy, Micro-F1 e Macro-F1, quando comparada com os algoritmos k-Means,
Bisecting k-Means e Non-Negative Matrix Factorization, Latent Dirichlet Allocation,
Simple Ranking, Ranking Clustering e Mixture Model. O algoritmo de propagação de
rótulos demonstrou-se promissor, principalmente quando aplicado a redes de similaridade.
Com isso, novas propostas com base nesse algoritmo serão exploradas em
trabalhos futuros.
