import React, { useEffect, useState } from "react";
import { Product, ShopContextState } from "../types";
import { fetchProducts } from "../api/ProductsApi";
import products from "../components/Products/Products";

const defaultState: ShopContextState = {
	products: [],
	reset: () => console.log("sad")
}

export const ShopContext = React.createContext(defaultState)

export const ShopContextProvider:React.FC<{children: React.ReactElement}> = ({children}) => {
	const [products, setProducts] = useState<Product[]>([]);

	useEffect(() => {
		fetchProducts().then(res => {
			// console.log(res);
			setProducts(res);
		})
	}, [])

	const providerValue: ShopContextState = {
		products,
		reset: () => setProducts([])
	}

	return (
		<ShopContext.Provider value={providerValue}>
			{children}
		</ShopContext.Provider>
	)
}
