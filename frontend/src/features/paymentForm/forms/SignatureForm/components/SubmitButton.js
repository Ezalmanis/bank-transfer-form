import Grid from "@material-ui/core/Grid";
import Button from "@material-ui/core/Button";
import React, {useState} from "react";
import {useSelector} from "react-redux";
import {selectPayment, selectTermsOfService,} from "../../../../components/payments/reducers/paymentSlice";
import {CreatePayment} from "../../../../components/payments/restApi/RestConfig";
import Modal from "@material-ui/core/Modal";
import {makeStyles} from "@material-ui/core/styles";

function rand() {
    return Math.round(Math.random() * 20) - 10;
}

function getModalStyle() {
    const top = 50 + rand();
    const left = 50 + rand();

    return {
        top: `${top}%`,
        left: `${left}%`,
        transform: `translate(-${top}%, -${left}%)`,
    };
}
const SubmitButton = () => {
    const [paymentSubmittedModal, setOpenSuccessModal] = useState({open: false});
    const [errorModalOpen, setOpenErrorModal] = useState({open: false});
    const [modalOpen, setModalOpen] = useState({open: false});

    const useStyles = makeStyles((theme) => ({
        paper: {
            position: 'absolute',
            width: 400,
            backgroundColor: theme.palette.background.paper,
            border: '2px solid #000',
            boxShadow: theme.shadows[5],
            padding: theme.spacing(2, 4, 3),
        },
    }));

    const classes = useStyles();
    const [modalStyle] = React.useState(getModalStyle);

    const handleCloseDefaultModal = () => {
        setModalOpen({open: false});
    };

    const handleCloseErrorModal = () => {
        setOpenErrorModal({open: false});
    };

    const handleCloseSuccessModal = () => {
        setOpenSuccessModal({open: false});
    };

    const termsOfServiceValue = useSelector(selectTermsOfService);
    const payment = useSelector(selectPayment);

    function handleSubmit() {
        SubmitPayment(payment)
    }

    return (
        <Grid>
            <div>
                <Modal
                    aria-labelledby="transition-modal-title"
                    aria-describedby="transition-modal-description"
                    className={classes.modal}
                    open={modalOpen.open}
                    onClose={handleCloseDefaultModal}
                >
                    <div style={modalStyle} className={classes.paper}>
                        <h2 id="transition-modal-title">Transaction submission pending</h2>
                        <p id="transition-modal-description">Please wait</p>
                    </div>
                </Modal>
                <Modal
                    aria-labelledby="success-modal-title"
                    aria-describedby="success-modal-description"
                    className={classes.modal}
                    open={paymentSubmittedModal.open}
                    onClose={handleCloseSuccessModal}
                >
                    <div style={modalStyle} className={classes.paper}>
                        <h2 id="success-modal-title">Transaction submission success</h2>
                        <p id="success-modal-description">Submission success, Please refresh the form</p>
                    </div>
                </Modal>
                <Modal
                    aria-labelledby="error-modal-title"
                    aria-describedby="error-modal-description"
                    className={classes.modal}
                    open={errorModalOpen.open}
                    onClose={handleCloseErrorModal}
                    closeAfterTransition>
                    <div style={modalStyle} className={classes.paper}>
                        <h2 id="error-modal-title"> Transaction submission error</h2>
                        <p id="error-modal-description">Submission error, Please try again later, or check all submitted values</p>
                    </div>
                </Modal>
            </div>
            <Button disabled={!termsOfServiceValue} color={'primary'}
                    onClick={() => handleSubmit()}>Submit</Button>
        </Grid>);

    async function SubmitPayment(payment) {
        console.log(JSON.stringify(payment));
        setModalOpen({open: true});
        await CreatePayment(JSON.stringify(payment))
            .then(response => {
                setModalOpen({open: false});
                setOpenSuccessModal({open: true});
            })
            .catch(e => {
                setModalOpen({open: false});
                setOpenErrorModal({open: true})
            });

    }
};
export default SubmitButton;




