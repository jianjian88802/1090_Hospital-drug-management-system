<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="80px"
                :style="{backgroundColor:addEditForm.addEditBoxColor}">
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='yaopin'">
                    <el-form-item class="select" v-if="type!='info'"  label="药品信息" prop="yaopinId">
                        <el-select v-model="ruleForm.yaopinId" :disabled="ro.yaopinId" filterable placeholder="请选择药品信息" @change="yaopinChange">
                            <el-option
                                    v-for="(item,index) in yaopinOptions"
                                    v-bind:key="item.id"
                                    :label="item.yaopinName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='yaopin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="药品名称" prop="yaopinName">
                        <el-input v-model="yaopinForm.yaopinName"
                                  placeholder="药品名称" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="药品名称" prop="yaopinName">
                            <el-input v-model="ruleForm.yaopinName"
                                      placeholder="药品名称" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yaopin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="药品类型" prop="yaopinValue">
                        <el-input v-model="yaopinForm.yaopinValue"
                                  placeholder="药品类型" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="药品类型" prop="yaopinValue">
                            <el-input v-model="ruleForm.yaopinValue"
                                      placeholder="药品类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yaopinChuruInout'">
                    <el-form-item class="select" v-if="type!='info'"  label="出入库" prop="yaopinChuruInoutId">
                        <el-select v-model="ruleForm.yaopinChuruInoutId" :disabled="ro.yaopinChuruInoutId" filterable placeholder="请选择出入库" @change="yaopinChuruInoutChange">
                            <el-option
                                    v-for="(item,index) in yaopinChuruInoutOptions"
                                    v-bind:key="item.id"
                                    :label="item.yaopinChuruInoutName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='yaopinChuruInout' ">
                    <el-form-item class="input" v-if="type!='info'"  label="出入库流水号" prop="yaopinChuruInoutUuidNumber">
                        <el-input v-model="yaopinChuruInoutForm.yaopinChuruInoutUuidNumber"
                                  placeholder="出入库流水号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="出入库流水号" prop="yaopinChuruInoutUuidNumber">
                            <el-input v-model="ruleForm.yaopinChuruInoutUuidNumber"
                                      placeholder="出入库流水号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yaopinChuruInout' ">
                    <el-form-item class="input" v-if="type!='info'"  label="出入库名称" prop="yaopinChuruInoutName">
                        <el-input v-model="yaopinChuruInoutForm.yaopinChuruInoutName"
                                  placeholder="出入库名称" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="出入库名称" prop="yaopinChuruInoutName">
                            <el-input v-model="ruleForm.yaopinChuruInoutName"
                                      placeholder="出入库名称" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yaopinChuruInout' ">
                    <el-form-item class="input" v-if="type!='info'"  label="出入库类型" prop="yaopinChuruInoutValue">
                        <el-input v-model="yaopinChuruInoutForm.yaopinChuruInoutValue"
                                  placeholder="出入库类型" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="出入库类型" prop="yaopinChuruInoutValue">
                            <el-input v-model="ruleForm.yaopinChuruInoutValue"
                                      placeholder="出入库类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="yaopinChuruInoutId" name="yaopinChuruInoutId" type="hidden">
            <input id="yaopinId" name="yaopinId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="操作数量" prop="yaopinChuruInoutListNumber">
                       <el-input v-model="ruleForm.yaopinChuruInoutListNumber"
                                 placeholder="操作数量" clearable  :readonly="ro.yaopinChuruInoutListNumber"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="操作数量" prop="yaopinChuruInoutListNumber">
                           <el-input v-model="ruleForm.yaopinChuruInoutListNumber"
                                     placeholder="操作数量" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                yaopinForm: {},
                yaopinChuruInoutForm: {},
                ro:{
                    yaopinChuruInoutId: false,
                    yaopinId: false,
                    yaopinChuruInoutListNumber: false,
                    insertTime: false,
                },
                ruleForm: {
                    yaopinChuruInoutId: '',
                    yaopinId: '',
                    yaopinChuruInoutListNumber: '',
                    insertTime: '',
                },
                yaopinOptions : [],
                yaopinChuruInoutOptions : [],
                rules: {
                   yaopinChuruInoutId: [
                              { required: true, message: '出入库不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   yaopinId: [
                              { required: true, message: '药品不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   yaopinChuruInoutListNumber: [
                              { required: true, message: '操作数量不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   insertTime: [
                              { required: true, message: '操作时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息

         this.$http({
             url: `yaopin/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.yaopinOptions = data.data.list;
            }
         });
         this.$http({
             url: `yaopinChuruInout/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.yaopinChuruInoutOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            yaopinChange(id){
                this.$http({
                    url: `yaopin/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.yaopinForm = data.data;
                    }
                });
            },
            yaopinChuruInoutChange(id){
                this.$http({
                    url: `yaopinChuruInout/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.yaopinChuruInoutForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `yaopinChuruInoutList/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.yaopinChange(data.data.yaopinId)
                        _this.yaopinChuruInoutChange(data.data.yaopinChuruInoutId)
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url:`yaopinChuruInoutList/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.yaopinChuruInoutListCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.yaopinChuruInoutListCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}</style>

