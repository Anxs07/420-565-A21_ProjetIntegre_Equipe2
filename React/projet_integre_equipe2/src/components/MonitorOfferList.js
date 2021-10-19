import React from 'react'
import { useState, useEffect } from 'react'
import './Form.css'
import { useHistory } from 'react-router-dom'
import MonitorNavbar from './MonitorNavbar'

const MonitorOfferList = () => {
    const [offers, setOffers] = useState([])
    const history = useHistory()
    const monitor = useHistory().location.state

    useEffect(() => {
        console.log(monitor)

        const getOffersByMonitor = async () => {
            const offersFromServer = await fetchOffersByMonitor()
            setOffers(offersFromServer)
        }
        getOffersByMonitor()
    }, [])

    const fetchOffersByMonitor = async () => {
        const res = await fetch(`http://localhost:8888/offer/get-all-offers/${monitor.id}`)
        return await res.json()
    }



    return (
        <div className="grad">
            <MonitorNavbar />
            <h2 className="text-center">Offres de stage</h2>
            <div className="p-5">
                <table className="table table-hover bg-light shadow-lg">
                    <thead>
                        <tr>
                            <th scope="col">Entreprise</th>
                            <th scope="col">Poste</th>
                            <th scope="col">Salaire</th>
                            <th scope="col">Date d'affichage</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        {offers.map((offer) => (
                            <tr key={offer.idOffer}>
                                <th>{offer.companyName}</th>
                                <td>{offer.jobTitle}</td>
                                <td>{offer.salary}$</td>
                                <td>{offer.displayDate}</td>
                                <td className="w-25">
                                    <button className="btn btn-primary mx-2" onClick={(e) => console.log(offer.id)}>Voir étudiants</button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default MonitorOfferList
