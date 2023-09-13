import { useRef, useState } from "react"
import axios from 'axios'


export default function HomePage() {

    let [email, setEmail] = useState('')
    let [password, setPassword] = useState('')
    let [name, setName] = useState('')
    let [address, setAddress] = useState('')
    let [phoneNumber, setPhoneNumber] = useState('')

    let emailRef = useRef()
    let passwordRef = useRef()
    let nameRef = useRef()
    let addressRef = useRef()
    let phoneNumberRef = useRef()

    function emailChangeHandler(event) {
        setEmail(event.target.value)
    }

    function passwordChangeHandler(event) {
        setPassword(event.target.value)
    }

    function nameChangeHandler(event) {
        setName(event.target.value)
    }

    function addressChangeHandler(event) {
        setAddress(event.target.value)
    }

    function phoneNumberChangeHandler(event) {
        setPhoneNumber(event.target.value)
    }

    const userData = {
        email: email,
        password: password,
        name: name,
        address: address,
        phoneNumber: phoneNumber,
    }

    function submitHanlder(event) {
        event.preventDefault()

        axios.post('http://localhost:9000/users/register', userData)
        .then(res => {
            console.log(res.status)
            console.log(res.data)
        })

        setEmail('')
        setPassword('')
        setName('')
        setAddress('')
        setPhoneNumber('')
    }

    return (
        <>
            <form onSubmit={submitHanlder}>
                <label className="form-label">Email:</label>
                <input
                    className="form-control"
                    ref={emailRef}
                    type="email"
                    id="email"
                    placeholder=""
                    value={email}
                    onChange={emailChangeHandler} />
                <label className="form-label">Password:</label>
                <input 
                    className="form-control"
                    ref={passwordRef}
                    type="password"
                    id="passowrd" 
                    placeholder=""
                    value={password}
                    onChange={passwordChangeHandler} />
                <label className="form-label">Name:</label>
                <input 
                    className="form-control"
                    ref={nameRef}
                    type="text"
                    id="name" 
                    placeholder=""
                    value={name}
                    onChange={nameChangeHandler} />
                <label className="form-label">Address:</label>
                <input 
                    className="form-control"
                    ref={addressRef}
                    type="text"
                    id="address" 
                    placeholder=""
                    value={address}
                    onChange={addressChangeHandler} />
                <label className="form-label">Phone Number:</label>
                <input 
                    className="form-control"
                    ref={phoneNumberRef}
                    type="tel"
                    id="phoneNumber" 
                    placeholder=""
                    value={phoneNumber}
                    onChange={phoneNumberChangeHandler} />
                <button className="btn btn-primary" type="submit">Register</button>
            </form>
        </>
    )
}