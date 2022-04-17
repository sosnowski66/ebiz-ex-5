import useBasket from "../hooks/useBasket";


const Basket = () => {
	const {products, removeProduct} = useBasket("Basket");

	return (
		<ul>
			{products.map(p => (
				<li key={p.id}>
					{p.name}
					<button onClick={() => removeProduct(p.id)}>
						Remove
					</button>
				</li>
			))}
		</ul>
	)
}

export default Basket;
