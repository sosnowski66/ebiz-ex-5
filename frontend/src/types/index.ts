export interface Product {
	id: number;
	name: string;
	description: string;
	category: string;
}

export interface ShopContextState {
	products: Product[],
	reset: () => void
}
