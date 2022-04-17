import React, { useContext } from "react";
import { ShopContext } from "../../context/ShopContext";
import useBasket from "../../hooks/useBasket";

const Products: React.FC = () => {
	const {products, reset} = useContext(ShopContext);
	const {addProduct} = useBasket("Products");

	return (
		<ul>
			{products.map(p => (
				<li key={p.id}>
					{p.name}
					<button onClick={() => addProduct(p)}>
						Add
					</button>
					<button onClick={reset}>
						RESET
					</button>
				</li>
			))}
		</ul>
	)
}

export default Products;
