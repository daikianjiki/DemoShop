import axios from "axios"
import { useEffect, useState } from "react"


export default function ProductPage() {

    let [products, setProducts] = useState([])

    function getProducts() {
        axios.get('http://localhost:9000/products')
        .then(res => {
            setProducts(res.data)
        })
    }

    useEffect(() => {
        getProducts()
    }, [])

    return (
        <>
            <ul>
                {products.map(product => (
                    <li key={product.id}>{product.name}</li>
                ))}
            </ul>
        </>
    )
}